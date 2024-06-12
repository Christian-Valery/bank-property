package com.evaluation.bankProperty.service.impl;

import com.evaluation.bankProperty.model.BorrowerEntity;
import com.evaluation.bankProperty.model.dto.BorrowerDto;
import com.evaluation.bankProperty.repository.BorrowerRepository;
import com.evaluation.bankProperty.service.IBorrowerService;
import org.springframework.beans.factory.annotation.Autowired;

public class BorrowerServiceImpl implements IBorrowerService {

    private BorrowerRepository borrowerRepository;

    @Autowired
    public BorrowerServiceImpl(BorrowerRepository _borrowerRepository){
        borrowerRepository = _borrowerRepository;
    }

    @Override
    public BorrowerEntity save(BorrowerDto borrowerDto) {
        return borrowerRepository.save(borrowerDto);
    }
}
