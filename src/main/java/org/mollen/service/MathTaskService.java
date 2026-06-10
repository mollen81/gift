package org.mollen.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mollen.entity.MathTask;
import org.mollen.entity.entity_type.MathTaskType;
import org.mollen.repo.MathTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class MathTaskService {
    @Autowired
    MathTaskRepository repository;

    public MathTask getTask(MathTaskType taskType, int result) {
        return repository.findMathTaskByTypeAndResult(taskType, result);
    }
}
