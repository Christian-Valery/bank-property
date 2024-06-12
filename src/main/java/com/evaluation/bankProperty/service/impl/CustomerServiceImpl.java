package com.evaluation.bankProperty.service.impl;

import com.evaluation.bankProperty.model.CustomerEntity;
import com.evaluation.bankProperty.model.dto.CustomerDto;
import com.evaluation.bankProperty.repository.CustomerRepository;
import com.evaluation.bankProperty.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceImpl implements ICustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository _customerRepository){
        customerRepository = _customerRepository;
    }

    @Override
    public CustomerEntity save(CustomerDto customerDto) {
        return customerRepository.save(customerDto);
    }
}
