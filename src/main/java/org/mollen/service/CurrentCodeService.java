package org.mollen.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mollen.entity.Code;
import org.mollen.repo.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@NoArgsConstructor
@AllArgsConstructor
public class CurrentCodeService {
    @Autowired
    CodeRepository repository;

    public Character getCodeSymbolByTaskNumber(int taskNumber) {
        Code code = repository.findFirstByOrderByCreatedAtDesc();
        return code.getCodeValue().charAt(taskNumber);
    }

}
