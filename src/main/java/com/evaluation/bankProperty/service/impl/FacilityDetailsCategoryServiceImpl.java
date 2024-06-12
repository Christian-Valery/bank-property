package com.evaluation.bankProperty.service.impl;

import com.evaluation.bankProperty.model.FacilityDetailsCategoryEntity;
import com.evaluation.bankProperty.repository.FacilityDetailsCategoryRepository;
import com.evaluation.bankProperty.service.IFacilityDetailsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityDetailsCategoryServiceImpl implements IFacilityDetailsCategoryService {
    private final FacilityDetailsCategoryRepository facilityDetailsCategoryRepository;

    @Autowired
    public FacilityDetailsCategoryServiceImpl(FacilityDetailsCategoryRepository _facilityDetailsCategoryRepository){
        facilityDetailsCategoryRepository = _facilityDetailsCategoryRepository;
    }

    @Override
    public List<FacilityDetailsCategoryEntity> findAll() {
        return facilityDetailsCategoryRepository.findAll();
    }
}
