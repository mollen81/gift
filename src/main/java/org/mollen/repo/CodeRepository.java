package org.mollen.repo;

import org.mollen.entity.Code;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CodeRepository extends CrudRepository<UUID, Code> {
    Code findFirstByOrderByCreatedAtDesc();
}
