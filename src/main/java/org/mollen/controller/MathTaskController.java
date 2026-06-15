package org.mollen.controller;

import org.mollen.entity.MathTask;
import org.mollen.entity.entity_type.MathTaskType;
import org.mollen.service.MathTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class MathTaskController {
    @Autowired
    MathTaskService mathTaskService;

    @GetMapping("math_task/welcome_page")
    public String mathTaskWelcome(Model model) {
        model.addAttribute(
                "description",
                "Далее будут представлены 3 математические задачи. За правильный ответ на каждую из них, будет предоставлена первая цифра кода!"
        );

        return "math_task_welcome";
    }


    @GetMapping("/math_task")
    public String mathTask(
            @RequestParam int step,
            Model model
    ) {

        MathTask task;
        switch(step) {
            case 1 -> task = mathTaskService.getRandomTaskByTaskType(MathTaskType.PATTERN);
            case 2 -> task = mathTaskService.getRandomTaskByTaskType(MathTaskType.DISCRIMINANT);
            case 3 -> task = mathTaskService.getRandomTaskByTaskType(MathTaskType.EQUATION);
            default -> {
                return "redirect:/math_task_finish";
            }
        }

        model.addAttribute("step", step);
        model.addAttribute("taskObject", task);

        return "math_task";
    }


    @PostMapping("/math_task_check")
    @ResponseBody
    public boolean mathTaskCheck(
            @RequestParam UUID taskId,
            @RequestParam double userAnswer)
    {
        return mathTaskService.isTaskAnswerCorrect(taskId, userAnswer);
    }


    @GetMapping("/math_task_finish")
    public String mathTaskFinish(Model model) {
        model.addAttribute("codeNumber", System.getenv("CODE").charAt(0));

        return "math_task_finish";
    }
}
