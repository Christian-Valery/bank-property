package com.evaluation.bankProperty.model.dto;

import com.evaluation.bankProperty.model.BorrowerEntity;
import com.evaluation.bankProperty.model.PropertyValuationEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PsValuationRequestDto {
    private String pvValuationRequestReference;
    private LocalDateTime receivingDate;
    private BorrowerEntity borrowerEntity;
    private PropertyValuationEntity propertyValuationEntity;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
}
