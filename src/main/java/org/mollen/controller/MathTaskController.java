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
@RequestMapping("/math_task")
public class MathTaskController {
    @Autowired
    MathTaskService mathTaskService;

    @GetMapping("/")
    public String mathTaskWelcome(Model model) {
        model.addAttribute(
                "description",
                "Далее будут представлены 3 математические задачи. За правильный ответ на каждую из них, будет предоставлена первая цифра кода!"
        );

        return "math_task_welcome";
    }


    @GetMapping("/math_task_1")
    public String mathTask1(Model model) {

        MathTask task =
                mathTaskService.getRandomTaskByTaskType(MathTaskType.PATTERN);

        model.addAttribute("taskObject", task);

        return "math_task";
    }

    @GetMapping("/math_task_2")
    public String mathTask2(Model model) {

        MathTask task =
                mathTaskService.getRandomTaskByTaskType(MathTaskType.DISCRIMINANT);

        model.addAttribute("taskObject", task);

        return "math_task";
    }

    @GetMapping("/math_task_3")
    public String mathTask3(Model model) {

        MathTask task =
                mathTaskService.getRandomTaskByTaskType(MathTaskType.EQUATION);

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
}
