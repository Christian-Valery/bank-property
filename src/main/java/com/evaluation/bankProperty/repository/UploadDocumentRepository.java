package com.evaluation.bankProperty.repository;

import com.evaluation.bankProperty.model.UploadedDocumentEntity;
import com.evaluation.bankProperty.model.dto.UploadDocumentDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadDocumentRepository extends JpaRepository<UploadedDocumentEntity, Integer> {
    UploadedDocumentEntity save(UploadDocumentDto uploadDocumentDto);
}
