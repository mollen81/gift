package org.mollen.controller;

import org.mollen.entity.PuzzleTask;
import org.mollen.service.PuzzleTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
public class PuzzleTaskController {
    @Autowired
    PuzzleTaskService puzzleTaskService;

    @GetMapping("/puzzle_task/welcome_page")
    public String puzzleTaskWelcome(Model model) {
        model.addAttribute(
                "description",
                "Распутай лабиринты линий, чтобы узнать зашифрованные слова. За успешное прохождение получишь четвертую цифру кода!"
        );
        return "puzzle_task_welcome";
    }

    @GetMapping("/puzzle_task")
    public String puzzleTask(@RequestParam int step, Model model) {
        // Проходим 3 шага (3 загадки)
        if (step > 1) {
            return "redirect:/puzzle_task_finish";
        }

        PuzzleTask task = puzzleTaskService.getRandomPuzzleTask();

        model.addAttribute("step", step);
        model.addAttribute("taskObject", task);

        return "puzzle_task";
    }

    @PostMapping("/puzzle_task_check")
    @ResponseBody
    public boolean puzzleTaskCheck(@RequestParam UUID taskId, @RequestParam String userAnswer) {
        return puzzleTaskService.isTaskAnswerCorrect(taskId, userAnswer);
    }

    @GetMapping("/puzzle_task_finish")
    public String puzzleTaskFinish(Model model) {
        // Извлекаем третью цифру секретного кода из переменной окружения
        model.addAttribute("codeNumber", System.getenv("CODE").charAt(3));
        return "puzzle_task_finish";
    }
}