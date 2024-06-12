package com.evaluation.bankProperty.service;

import com.evaluation.bankProperty.model.FacilityDetailsPurposeEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IFacilityDetailsPurposeService {
    List<FacilityDetailsPurposeEntity> findAll();
}
