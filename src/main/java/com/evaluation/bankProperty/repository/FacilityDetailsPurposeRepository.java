package com.evaluation.bankProperty.repository;

import com.evaluation.bankProperty.model.FacilityDetailsPurposeEntity;
import com.evaluation.bankProperty.model.dto.FacilityDetailsPurposeDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityDetailsPurposeRepository extends JpaRepository<FacilityDetailsPurposeEntity, Integer> {
    FacilityDetailsPurposeEntity save(FacilityDetailsPurposeDto facilityDetailsPurposeDto);
}
