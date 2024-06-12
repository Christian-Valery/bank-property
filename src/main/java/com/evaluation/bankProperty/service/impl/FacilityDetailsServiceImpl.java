package com.evaluation.bankProperty.service.impl;

import com.evaluation.bankProperty.model.FacilityDetailsEntity;
import com.evaluation.bankProperty.model.dto.FacilityDetailsDto;
import com.evaluation.bankProperty.repository.FacilityDetailsRepository;
import com.evaluation.bankProperty.repository.UserRepository;
import com.evaluation.bankProperty.service.IFacilityDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacilityDetailsServiceImpl implements IFacilityDetailsService {

    @Autowired
    private FacilityDetailsRepository facilityDetailsRepository;

    public FacilityDetailsEntity save(FacilityDetailsDto facilityDetailsDto) {
        return facilityDetailsRepository.save(facilityDetailsDto);
    }
}
