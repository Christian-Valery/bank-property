package com.evaluation.bankProperty.service.impl;

import com.evaluation.bankProperty.model.PropertyValuationTypeEntity;
import com.evaluation.bankProperty.repository.PropertyValuationTypeRepository;
import com.evaluation.bankProperty.service.IPropertyValuationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyValuationTypeServiceImpl implements IPropertyValuationTypeService {

    @Autowired
    private PropertyValuationTypeRepository propertyValuationTypeRepository;

    @Override
    public List<PropertyValuationTypeEntity> findAll() {
        return propertyValuationTypeRepository.findAll();
    }
}
