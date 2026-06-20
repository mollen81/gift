package org.mollen.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mollen.entity.PuzzleTask;
import org.mollen.repo.PuzzleTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class PuzzleTaskService {
    @Autowired
    PuzzleTaskRepository repository;

    public PuzzleTask getRandomPuzzleTask() {
        return repository.getRandomPuzzleTask();
    }

    public boolean isTaskAnswerCorrect(@RequestParam UUID taskId, @RequestParam String answer) {
        return repository.findById(taskId)
                .map(task -> task.getResult().trim().equalsIgnoreCase(answer.trim()))
                .orElse(false);
    }
}