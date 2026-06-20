package org.mollen.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mollen.entity.ColorCountTask;
import org.mollen.repo.ColorCountTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class ColorCountTaskService {
    @Autowired
    ColorCountTaskRepository repository;

    public ColorCountTask getRandomColorTask() {
        return repository.getRandomColorTask();
    }

    public boolean isTaskAnswerCorrect(@RequestParam UUID taskId, @RequestParam int answer) {
        return repository.findById(taskId)
                .map(task -> task.getResult() == answer)
                .orElse(false);
    }
}