package org.mollen.repo;

import org.mollen.entity.MathTask;
import org.mollen.entity.entity_type.MathTaskType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MathTaskRepository extends CrudRepository<MathTask, UUID> {
    @Query(value = """
                    SELECT *
                    FROM math_tasks
                    WHERE task_type = :type           
                    ORDER BY RANDOM()
                    LIMIT 1      
                    """,
            nativeQuery = true)
    MathTask getRandomMathTaskByType(MathTaskType type);
}
