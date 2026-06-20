package org.mollen.repo;

import org.mollen.entity.ColorCountTask;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ColorCountTaskRepository extends CrudRepository<ColorCountTask, UUID> {
    @Query(value = """
                    SELECT *
                    FROM color_tasks
                    ORDER BY RANDOM()
                    LIMIT 1
                    """, nativeQuery = true)
    ColorCountTask getRandomColorTask();
}