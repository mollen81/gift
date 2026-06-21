package org.mollen.controller;

import org.mollen.entity.MorseCode;
import org.mollen.service.MorseCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
public class MorseCodeController {
    @Autowired
    MorseCodeService morseCodeService;

    @GetMapping("/morse_code/welcome_page")
    public String morseCodeWelcomePage(Model model) {
        model.addAttribute(
                "description",
                "Далее будут представлена азбука морзе. За правильный ответ на задачу, будет предоставлена вторая и третья цифра кода!"
                );

        return "morse_code_welcome";
    }

    @GetMapping("/morse_code/task")
    public String morseCodeTask(
            @RequestParam int step,
            Model model) {
        MorseCode morseCode;

        switch (step) {
            case 1, 2 -> morseCode = morseCodeService.getRandomMorseCode();
            default -> {
                return "redirect:/morse_code_finish";
            }
        }

        model.addAttribute("step", step);
        model.addAttribute("taskObject", morseCode);
        model.addAttribute("taskDescription", morseCode.getQuestion());
        model.addAttribute("morseText", morseCode.getMorseText());
        model.addAttribute("taskId", morseCode.getUuid());


        return "morse_code_task";
    }


    @PostMapping("/morse_code_check")
    @ResponseBody
    public boolean morseCodeTaskCheck(@RequestParam UUID taskId, @RequestParam int answer) {
        return morseCodeService.isTaskAnswerCorrect(taskId, answer);
    }

    @PostMapping("/morse_code_check_riddle")
    @ResponseBody
    public boolean morseCodeRiddleCheck(@RequestParam UUID taskId, @RequestParam String userAnswer) {
        return morseCodeService.isRiddleAnswerCorrect(taskId, userAnswer);
    }


    @GetMapping("/morse_code_finish")
    public String morseCodeFinish(Model model) {
        model.addAttribute("codeNumber", System.getenv("CODE").substring(1, 3));

        return "morse_code_finish";
    }
}