package com.evaluation.bankProperty.repository;

import com.evaluation.bankProperty.model.PsValuationRequestEntity;
import com.evaluation.bankProperty.model.dto.PsValuationRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PsValuationRequestRepository extends JpaRepository<PsValuationRequestEntity, Integer> {

    PsValuationRequestEntity save(PsValuationRequestDto psValuationRequestDto);

    @Query(value = "SELECT MAX('idpvsvaluationrequest') FROM PsValuationRequestEntity")
    Integer findMaxId();
}
