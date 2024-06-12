package com.evaluation.bankProperty.service.impl;

import com.evaluation.bankProperty.model.DocumentTypeEntity;
import com.evaluation.bankProperty.model.dto.DocumentTypeDto;
import com.evaluation.bankProperty.repository.DocumentTypeRepository;
import com.evaluation.bankProperty.service.IDocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentTypeServiceImpl implements IDocumentTypeService{

    private final DocumentTypeRepository documentTypeRepository;

    @Autowired
    public DocumentTypeServiceImpl(DocumentTypeRepository _documentTypeRepository){
        documentTypeRepository = _documentTypeRepository;
    }
    @Override
    public DocumentTypeEntity save(DocumentTypeDto documentTypeDto) {
        return documentTypeRepository.save(documentTypeDto);
    }

    @Override
    public List<DocumentTypeEntity> findAll() {
        return documentTypeRepository.findAll();
    }
}
