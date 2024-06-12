package com.evaluation.bankProperty.service;

import com.evaluation.bankProperty.model.CustomerEntity;
import com.evaluation.bankProperty.model.dto.CustomerDto;
import org.springframework.stereotype.Service;

@Service
public interface ICustomerService {
    CustomerEntity save (CustomerDto customerDto);
}
