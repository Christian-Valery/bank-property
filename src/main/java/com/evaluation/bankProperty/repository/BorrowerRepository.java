package com.evaluation.bankProperty.repository;

import com.evaluation.bankProperty.model.BorrowerEntity;
import com.evaluation.bankProperty.model.dto.BorrowerDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowerRepository extends JpaRepository<BorrowerEntity, Integer> {
    BorrowerEntity save(BorrowerDto borrowerDto);
}
