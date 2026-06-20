package org.mollen.repo;

import org.mollen.entity.PuzzleTask;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PuzzleTaskRepository extends CrudRepository<PuzzleTask, UUID> {
    @Query(value = """
                    SELECT *
                    FROM puzzle_tasks
                    ORDER BY RANDOM()
                    LIMIT 1
                    """, nativeQuery = true)
    PuzzleTask getRandomPuzzleTask();
}