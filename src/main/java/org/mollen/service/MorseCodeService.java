package org.mollen.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mollen.entity.MorseCode;
import org.mollen.repo.MorseCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class MorseCodeService {
    @Autowired
    MorseCodeRepository repository;

    public MorseCode getRandomMorseCode() {
        return repository.getRandomMorseCode();
    }

    public boolean isTaskAnswerCorrect(@RequestParam UUID taskId, @RequestParam int answer) {
        return repository.findById(taskId)
                .map(task -> task.getResult() == answer)
                .orElse(false);
    }

    public boolean isRiddleAnswerCorrect(UUID taskId, String answer) {
        return repository.findById(taskId)
                .map(task -> task.getRiddleAnswer().trim().equalsIgnoreCase(answer.trim()))
                .orElse(false);
    }
}
