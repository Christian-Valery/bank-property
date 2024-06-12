package com.evaluation.bankProperty.service;

import com.evaluation.bankProperty.model.PropertyValuationEntity;
import com.evaluation.bankProperty.model.dto.PropertyValuationDto;
import org.springframework.stereotype.Service;

@Service
public interface IPropertyValuationService {
    PropertyValuationEntity save(PropertyValuationDto propertyValuationDto);
}
