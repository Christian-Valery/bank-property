package com.evaluation.bankProperty.service.impl;

import com.evaluation.bankProperty.model.FacilityDetailsPurposeEntity;
import com.evaluation.bankProperty.repository.FacilityDetailsPurposeRepository;
import com.evaluation.bankProperty.service.IFacilityDetailsPurposeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityDetailsPurposeServiceImpl implements IFacilityDetailsPurposeService {
    private final FacilityDetailsPurposeRepository facilityDetailsPurposeRepository;

    @Autowired
    public FacilityDetailsPurposeServiceImpl(FacilityDetailsPurposeRepository _facilityDetailsPurposeRepository){
        facilityDetailsPurposeRepository = _facilityDetailsPurposeRepository;
    }

    @Override
    public List<FacilityDetailsPurposeEntity> findAll() {
        return facilityDetailsPurposeRepository.findAll();
    }
}
