package com.evaluation.bankProperty.model.dto;

import com.evaluation.bankProperty.model.DocumentTypeEntity;
import com.evaluation.bankProperty.model.UsersEntity;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class UploadDocumentDto {
    private DocumentTypeEntity documentTypeEntity;
    private String documentFileName;
    private double documentSizeValue;
    private String documentSizeTermination;
    private UsersEntity usersEntityUploader;
    private ZonedDateTime uploadingDate;
}
