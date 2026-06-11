package org.mollen.repo;

import org.mollen.entity.MathTask;
import org.mollen.entity.entity_type.MathTaskType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MathTaskRepository extends CrudRepository<MathTask, UUID> {
    MathTask findMathTaskByType(MathTaskType type);
}
