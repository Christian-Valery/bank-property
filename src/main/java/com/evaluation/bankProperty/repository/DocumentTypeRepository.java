package com.evaluation.bankProperty.repository;

import com.evaluation.bankProperty.model.DocumentTypeEntity;
import com.evaluation.bankProperty.model.dto.DocumentTypeDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentTypeRepository extends JpaRepository<DocumentTypeEntity, Integer> {
    DocumentTypeEntity save(DocumentTypeDto documentTypeDto);
}
