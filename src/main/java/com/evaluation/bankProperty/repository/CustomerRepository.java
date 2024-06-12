package com.evaluation.bankProperty.repository;


import com.evaluation.bankProperty.model.CustomerEntity;
import com.evaluation.bankProperty.model.dto.CustomerDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    CustomerEntity save(CustomerDto customerDto);
}
