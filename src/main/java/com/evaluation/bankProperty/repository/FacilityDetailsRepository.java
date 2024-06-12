package com.evaluation.bankProperty.repository;

import com.evaluation.bankProperty.model.FacilityDetailsEntity;
import com.evaluation.bankProperty.model.dto.FacilityDetailsDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityDetailsRepository extends JpaRepository<FacilityDetailsEntity, Integer> {
    FacilityDetailsEntity save(FacilityDetailsDto facilityDetailsDto);
}
