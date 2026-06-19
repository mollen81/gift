package org.mollen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MorseCodeController {
    @GetMapping("/morse_code/welcome_page")
    public String morseCodeWelcomePage(Model model) {
        model.addAttribute(
                "description",
                "Далее будут представлена азбука морзе. За правильный ответ на задачу, будет предоставлена вторая цифра кода!"
                );

        return "morse_code_welcome";
    }
}
