package com.evaluation.bankProperty.service;

import com.evaluation.bankProperty.model.BorrowerEntity;
import com.evaluation.bankProperty.model.dto.BorrowerDto;
import org.springframework.stereotype.Service;

@Service
public interface IBorrowerService {
    BorrowerEntity save(BorrowerDto borrowerDto);
}
