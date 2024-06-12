package com.evaluation.bankProperty.service;

import com.evaluation.bankProperty.model.FacilityDetailsEntity;
import com.evaluation.bankProperty.model.dto.FacilityDetailsDto;
import org.springframework.stereotype.Service;

@Service
public interface IFacilityDetailsService {
    FacilityDetailsEntity save(FacilityDetailsDto facilityDetailsDto);
}
