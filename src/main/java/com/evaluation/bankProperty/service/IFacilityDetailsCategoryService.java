package com.evaluation.bankProperty.service;

import com.evaluation.bankProperty.model.FacilityDetailsCategoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IFacilityDetailsCategoryService {
    List<FacilityDetailsCategoryEntity> findAll();
}
