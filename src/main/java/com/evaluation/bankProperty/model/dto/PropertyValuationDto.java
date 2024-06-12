package com.evaluation.bankProperty.model.dto;

import com.evaluation.bankProperty.model.PropertyValuationTypeEntity;
import lombok.Data;

@Data
public class PropertyValuationDto {
    private String propertyValuationFosRef;
    private PropertyValuationTypeEntity propertyValuationTypeEntity;
}
