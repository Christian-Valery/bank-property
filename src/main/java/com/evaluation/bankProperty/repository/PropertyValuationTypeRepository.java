package com.evaluation.bankProperty.repository;

import com.evaluation.bankProperty.model.PropertyValuationTypeEntity;
import com.evaluation.bankProperty.model.dto.PropertyValuationTypeDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyValuationTypeRepository extends JpaRepository<PropertyValuationTypeEntity, Integer> {
    PropertyValuationTypeEntity save (PropertyValuationTypeDto propertyValuationTypeDto);
}
