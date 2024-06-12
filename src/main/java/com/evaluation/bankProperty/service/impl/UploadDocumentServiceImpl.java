package com.evaluation.bankProperty.service.impl;

import com.evaluation.bankProperty.model.UploadedDocumentEntity;
import com.evaluation.bankProperty.model.dto.UploadDocumentDto;
import com.evaluation.bankProperty.repository.UploadDocumentRepository;
import com.evaluation.bankProperty.service.IUploadDocumentService;
import org.springframework.beans.factory.annotation.Autowired;

public class UploadDocumentServiceImpl implements IUploadDocumentService {
    private UploadDocumentRepository uploadDocumentRepository;

    @Autowired
    public UploadDocumentServiceImpl(UploadDocumentRepository _uploadDocumentRepository){
        uploadDocumentRepository = _uploadDocumentRepository;
    }

    @Override
    public UploadedDocumentEntity save(UploadDocumentDto uploadDocumentDto) {
        return uploadDocumentRepository.save(uploadDocumentDto);
    }
}
