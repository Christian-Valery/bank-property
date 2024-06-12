package com.evaluation.bankProperty.service.impl;

import com.evaluation.bankProperty.model.PropertyValuationEntity;
import com.evaluation.bankProperty.model.dto.PropertyValuationDto;
import com.evaluation.bankProperty.repository.PropertyValuationRepository;
import com.evaluation.bankProperty.service.IPropertyValuationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyValuationServiceImpl implements IPropertyValuationService {

    @Autowired
    private PropertyValuationRepository propertyValuationRepository;

    @Override
    public PropertyValuationEntity save(PropertyValuationDto propertyValuationDto) {
        return propertyValuationRepository.save(propertyValuationDto);
    }
}
