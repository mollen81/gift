package org.mollen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Controller
public class ObninskQuestController {

    // Массив букв для последовательного сбора слова Л Ю Б О В Ь
    private static final char[] WORD_CHARS = {'Л', 'Ю', 'Б', 'О', 'В', 'Ь'};

    // Подсказки для интерфейса
    private static final Map<Integer, String> STEP_HINTS = Map.of(
            1, "Придумай или найди место в Обнинске, содержащее букву 'Л'.",
            2, "Придумай или найди место в Обнинске, содержащее букву 'Ю'.",
            3, "Придумай или найди место в Обнинске, содержащее букву 'Б'.",
            4, "Придумай или найди место в Обнинске, содержащее букву 'О'.",
            5, "Придумай или найди место в Обнинске, содержащее букву 'В'.",
            6, "Придумай или найди место в Обнинске, содержащее букву 'Ь'."
    );

    @GetMapping("/obninsk_quest/welcome_page")
    public String questWelcome(Model model) {
        model.addAttribute("description",
                "Добро пожаловать в финальный блок! Чтобы получить последнюю цифру кода, тебе предстоит собрать слово ЛЮБОВЬ. На каждом шаге вводи любое место города Обнинск, главное — чтобы в его названии была нужная буква, и прикрепляй его фотографию!");
        return "obninsk_quest_welcome";
    }

    @GetMapping("/obninsk_quest")
    public String questStage(@RequestParam int step, Model model) {
        if (step < 1 || step > 6) {
            return "redirect:/obninsk_quest_finish";
        }

        model.addAttribute("step", step);
        model.addAttribute("targetChar", WORD_CHARS[step - 1]);
        model.addAttribute("hintText", STEP_HINTS.get(step));
        return "obninsk_quest";
    }

    @PostMapping("/obninsk_quest_check")
    @ResponseBody
    public boolean checkLocationAnswer(
            @RequestParam int step,
            @RequestParam String locationName,
            @RequestParam("locationPhoto") MultipartFile file) {

        if (step < 1 || step > 6 || locationName == null || locationName.isBlank()) {
            return false;
        }

        // Берём целевую букву для текущего шага
        char targetChar = WORD_CHARS[step - 1];

        // Валидация: Проверяем исключительно наличие буквы в строке (в любом регистре)
        return locationName.toUpperCase().contains(String.valueOf(targetChar));
    }

    @GetMapping("/obninsk_quest_finish")
    public String questFinish(Model model) {
        // Извлекаем 6-ю цифру секретного кода (индекс 5) из переменной окружения
        model.addAttribute("codeNumber", System.getenv("CODE").charAt(5));
        return "obninsk_quest_finish";
    }
}