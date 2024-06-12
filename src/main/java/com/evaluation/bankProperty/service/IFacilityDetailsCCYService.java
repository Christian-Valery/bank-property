package com.evaluation.bankProperty.service;

import com.evaluation.bankProperty.model.FacilityDetailsCCYEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IFacilityDetailsCCYService {
    List<FacilityDetailsCCYEntity> findAll();
}
