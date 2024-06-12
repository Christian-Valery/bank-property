package com.evaluation.bankProperty.service;

import com.evaluation.bankProperty.model.UploadedDocumentEntity;
import com.evaluation.bankProperty.model.dto.UploadDocumentDto;
import org.springframework.stereotype.Service;

@Service
public interface IUploadDocumentService {
    UploadedDocumentEntity save(UploadDocumentDto uploadDocumentDto);
}
