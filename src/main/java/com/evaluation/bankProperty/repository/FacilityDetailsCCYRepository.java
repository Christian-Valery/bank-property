package com.evaluation.bankProperty.repository;

import com.evaluation.bankProperty.model.FacilityDetailsCCYEntity;
import com.evaluation.bankProperty.model.FacilityDetailsCategoryEntity;
import com.evaluation.bankProperty.model.FacilityDetailsEntity;
import com.evaluation.bankProperty.model.dto.FacilityDetailsCCYDto;
import com.evaluation.bankProperty.model.dto.FacilityDetailsDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityDetailsCCYRepository extends JpaRepository<FacilityDetailsCCYEntity, Integer> {
    FacilityDetailsCCYEntity save(FacilityDetailsCCYDto facilityDetailsCCYDto);
}
