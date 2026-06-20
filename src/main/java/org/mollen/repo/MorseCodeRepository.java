package org.mollen.repo;

import org.mollen.entity.MorseCode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MorseCodeRepository extends CrudRepository<MorseCode, UUID> {
    @Query(value = """
                    SELECT *
                    FROM morse_codes
                    ORDER BY RANDOM()
                    LIMIT 1
                    """, nativeQuery = true)
    MorseCode getRandomMorseCode();
}
