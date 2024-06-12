package com.evaluation.bankProperty.repository;

import com.evaluation.bankProperty.model.FacilityDetailsCategoryEntity;
import com.evaluation.bankProperty.model.dto.FacilityDetailsCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityDetailsCategoryRepository extends JpaRepository<FacilityDetailsCategoryEntity, Integer> {
    FacilityDetailsCategoryEntity save(FacilityDetailsCategoryDto facilityDetailsCategoryDto);
}
