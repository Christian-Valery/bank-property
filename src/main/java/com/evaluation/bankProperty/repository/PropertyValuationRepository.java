package com.evaluation.bankProperty.repository;


import com.evaluation.bankProperty.model.PropertyValuationEntity;
import com.evaluation.bankProperty.model.dto.PropertyValuationDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyValuationRepository extends JpaRepository<PropertyValuationEntity, Integer> {
    PropertyValuationEntity save (PropertyValuationDto propertyValuationDto);
}
