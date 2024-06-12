package com.evaluation.bankProperty.service.impl;

import com.evaluation.bankProperty.model.FacilityDetailsCCYEntity;
import com.evaluation.bankProperty.repository.FacilityDetailsCCYRepository;
import com.evaluation.bankProperty.service.IFacilityDetailsCCYService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityDetailsCCYServiceImpl implements IFacilityDetailsCCYService {
    private final FacilityDetailsCCYRepository facilityDetailsCCYRepository;

    @Autowired
    public FacilityDetailsCCYServiceImpl(FacilityDetailsCCYRepository _facilityDetailsCCYRepository){
        facilityDetailsCCYRepository = _facilityDetailsCCYRepository;
    }

    @Override
    public List<FacilityDetailsCCYEntity> findAll() {
        return facilityDetailsCCYRepository.findAll();
    }
}
