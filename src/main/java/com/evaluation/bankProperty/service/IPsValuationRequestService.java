package com.evaluation.bankProperty.service;

import com.evaluation.bankProperty.model.PsValuationRequestEntity;
import com.evaluation.bankProperty.model.dto.PsValuationRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPsValuationRequestService {
    PsValuationRequestEntity save(PsValuationRequestDto psValuationRequestDto);
    Integer maxId();
    List<PsValuationRequestEntity> getAllEntities();
}
