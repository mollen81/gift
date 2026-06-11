package org.mollen.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mollen.entity.MathTask;
import org.mollen.entity.entity_type.MathTaskType;
import org.mollen.repo.MathTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
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

    public boolean isTaskAnswerCorrect(UUID taskId, double answer) {
        Optional<MathTask> task = repository.findById(taskId);
        Double correctAnswer = null;
        if(task.isPresent()) {
            correctAnswer = task.get().getResult();
        }

        assert correctAnswer != null;
        return correctAnswer.equals(answer);
    }
}
