package com.evaluation.bankProperty.service.impl;

import com.evaluation.bankProperty.model.PsValuationRequestEntity;
import com.evaluation.bankProperty.model.dto.PsValuationRequestDto;
import com.evaluation.bankProperty.repository.PsValuationRequestRepository;
import com.evaluation.bankProperty.service.IPsValuationRequestService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PsValuationRequestService implements IPsValuationRequestService {

    private final PsValuationRequestRepository psValuationRequestRepository;

    @Autowired
    public PsValuationRequestService(PsValuationRequestRepository _psValuationRequestRepository){
        psValuationRequestRepository = _psValuationRequestRepository;
    }
    @Override
    public PsValuationRequestEntity save(PsValuationRequestDto psValuationRequestDto) {
        return psValuationRequestRepository.save(psValuationRequestDto);
    }

    @Override
    public Integer maxId() {
        return psValuationRequestRepository.findMaxId();
    }

    @Override
    public List<PsValuationRequestEntity> getAllEntities() {
        return psValuationRequestRepository.findAll();
    }

}
