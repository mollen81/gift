package org.mollen.controller;

import org.mollen.entity.ColorCountTask;
import org.mollen.service.ColorCountTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
public class ColorCountTaskController {
    @Autowired
    ColorCountTaskService colorCountTaskService;

    @GetMapping("/color_task/welcome_page")
    public String colorTaskWelcome(Model model) {
        model.addAttribute(
                "description",
                "Следующий блок проверит твою внимательность. Изучи картинки и посчитай нужные элементы. За прохождение получишь четвертую цифру кода!"
        );
        return "color_task_welcome";
    }

    @GetMapping("/color_task")
    public String colorTask(@RequestParam int step, Model model) {
        // Допустим, здесь тоже 3 шага
        if (step > 1) {
            return "redirect:/color_task_finish";
        }

        ColorCountTask task = colorCountTaskService.getRandomColorTask();

        model.addAttribute("step", step);
        model.addAttribute("taskObject", task);

        return "color_task";
    }

    @PostMapping("/color_task_check")
    @ResponseBody
    public boolean colorTaskCheck(@RequestParam UUID taskId, @RequestParam int userAnswer) {
        return colorCountTaskService.isTaskAnswerCorrect(taskId, userAnswer);
    }

    @GetMapping("/color_task_finish")
    public String colorTaskFinish(Model model) {
        model.addAttribute("codeNumber", System.getenv("CODE").charAt(4));
        return "color_task_finish";
    }
}