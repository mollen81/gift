package org.mollen.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mollen.entity.MathTask;
import org.mollen.entity.entity_type.MathTaskType;
import org.mollen.repo.MathTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class MathTaskService {
    @Autowired
    MathTaskRepository repository;

    public MathTask getRandomTaskByTaskType(MathTaskType taskType) {
        return repository.getRandomMathTaskByType(taskType);
    }

    public boolean isTaskAnswerCorrect(@RequestParam UUID taskId, @RequestParam double answer) {
        return repository.findById(taskId)
                .map(task -> task.getResult() == answer)
                .orElse(false);
    }
}
