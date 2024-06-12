package com.evaluation.bankProperty.service;

import com.evaluation.bankProperty.model.PropertyValuationTypeEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPropertyValuationTypeService {
    List<PropertyValuationTypeEntity> findAll();
}
