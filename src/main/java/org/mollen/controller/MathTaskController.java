package org.mollen.controller;

import org.mollen.entity.entity_type.MathTaskType;
import org.mollen.service.MathTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class MathTaskController {
    @Autowired
    MathTaskService mathTaskService;


    @GetMapping("/math_task")
    public String mathTaskWelcome(Model model) {
        model.addAttribute(
                "description",
                "Далее будут представлены 3 математические задачи. За правильный ответ на каждую из них, будет предоставлена первая цифра кода!"
        );

        return "math_task_welcome";
    }


    @GetMapping("/math_task/math_task_1")
    public String mathTask_1(Model model) {
        String taskDescription = mathTaskService.getTask(
                MathTaskType.PATTERN).getTaskDescription();
        String taskText = mathTaskService.getTask(
                MathTaskType.PATTERN).getTaskText();
        int taskResult = mathTaskService.getTask(
                MathTaskType.PATTERN).getResult();

        model.addAttribute(
                "taskDescription",
                taskDescription
        );

        model.addAttribute(
                "taskText",
                taskText
        );

        model.addAttribute(
                "taskResult",
                taskResult
        );

        return "math_task_1";
    }

    @GetMapping("/math_task/math_task_2")
    public String mathTask_2(Model model) {
        String taskDescription = mathTaskService.getTask(
                MathTaskType.DISCRIMINANT).getTaskDescription();
        String taskText = mathTaskService.getTask(
                MathTaskType.DISCRIMINANT).getTaskText();
        int taskResult = mathTaskService.getTask(
                MathTaskType.DISCRIMINANT).getResult();

        model.addAttribute(
                "taskDescription",
                taskDescription
        );

        model.addAttribute(
                "taskText",
                taskText
        );

        model.addAttribute(
                "taskResult",
                taskResult
        );

        return "math_task_2";
    }

    @GetMapping("/math_task/math_task_3")
    public String mathTask_3(Model model) {
        String taskDescription = mathTaskService.getTask(
                MathTaskType.EQUATION).getTaskDescription();
        String taskText = mathTaskService.getTask(
                MathTaskType.EQUATION).getTaskText();
        int taskResult = mathTaskService.getTask(
                MathTaskType.EQUATION).getResult();

        model.addAttribute(
                "taskDescription",
                taskDescription
        );

        model.addAttribute(
                "taskText",
                taskText
        );

        model.addAttribute(
                "taskResult",
                taskResult
        );

        return "math_task_3";
    }


    @GetMapping("/math_task_check_answer")
    public boolean mathTaskCheck(@RequestParam double userAnswer, Model model) {
        
    }
}
