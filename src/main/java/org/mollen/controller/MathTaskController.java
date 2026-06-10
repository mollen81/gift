package org.mollen.controller;

import org.mollen.entity.entity_type.MathTaskType;
import org.mollen.service.CurrentCodeService;
import org.mollen.service.MathTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class MathTaskController {
    @Autowired
    MathTaskService mathTaskService;

    @Autowired
    CurrentCodeService currentCodeService;

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
        model.addAttribute(
                "taskDescription",
                mathTaskService.getTask(
                        MathTaskType.PATTERN,
                        currentCodeService.getCodeSymbolByTaskNumber(0)
                ).getTaskDescription()
        );

        model.addAttribute(
                "taskText",
                mathTaskService.getTask(
                        MathTaskType.PATTERN,
                        currentCodeService.getCodeSymbolByTaskNumber(0)
                ).getTaskText()
        );

        model.addAttribute(
                "taskResult",
                mathTaskService.getTask(
                        MathTaskType.PATTERN,
                        currentCodeService.getCodeSymbolByTaskNumber(0)
                ).getResult()
        );

        return "math_task_1";
    }

    @GetMapping("/math_task/math_task_2")
    public String mathTask_2(Model model) {
        model.addAttribute(
                "taskDescription",
                mathTaskService.getTask(
                        MathTaskType.DISCRIMINANT,
                        currentCodeService.getCodeSymbolByTaskNumber(1)
                ).getTaskDescription()
        );

        model.addAttribute(
                "taskText",
                mathTaskService.getTask(
                        MathTaskType.DISCRIMINANT,
                        currentCodeService.getCodeSymbolByTaskNumber(1)
                ).getTaskText()
        );

        model.addAttribute(
                "taskResult",
                mathTaskService.getTask(
                        MathTaskType.DISCRIMINANT,
                        currentCodeService.getCodeSymbolByTaskNumber(1)
                ).getResult()
        );

        return "math_task_2";
    }

    @GetMapping("/math_task/math_task_3")
    public String mathTask_3(Model model) {
        model.addAttribute(
                "taskDescription",
                mathTaskService.getTask(
                        MathTaskType.EQUATION,
                        currentCodeService.getCodeSymbolByTaskNumber(2)
                ).getTaskDescription()
        );

        model.addAttribute(
                "taskText",
                mathTaskService.getTask(
                        MathTaskType.EQUATION,
                        currentCodeService.getCodeSymbolByTaskNumber(2)
                ).getTaskText()
        );

        model.addAttribute(
                "taskResult",
                mathTaskService.getTask(
                        MathTaskType.EQUATION,
                        currentCodeService.getCodeSymbolByTaskNumber(2)
                ).getResult()
        );

        return "math_task_3";
    }
}
