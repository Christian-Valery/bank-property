package com.evaluation.bankProperty.service;

import com.evaluation.bankProperty.model.DocumentTypeEntity;
import com.evaluation.bankProperty.model.dto.DocumentTypeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDocumentTypeService {
    DocumentTypeEntity save(DocumentTypeDto documentTypeDto);
    List<DocumentTypeEntity> findAll();
}
