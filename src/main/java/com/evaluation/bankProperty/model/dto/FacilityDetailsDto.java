package com.evaluation.bankProperty.model.dto;

import com.evaluation.bankProperty.model.FacilityDetailsCCYEntity;
import com.evaluation.bankProperty.model.FacilityDetailsCategoryEntity;
import com.evaluation.bankProperty.model.FacilityDetailsPurposeEntity;
import com.evaluation.bankProperty.model.FacilityDetailsTypeEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class FacilityDetailsDto {

    private FacilityDetailsTypeEntity facilityDetailsTypeEntity;
    private FacilityDetailsCategoryEntity facilityDetailsCategoryEntity;
    private FacilityDetailsPurposeEntity facilityDetailsPurposeEntity;
    private int term;
    private FacilityDetailsCCYEntity facilityDetailsCCYEntity;
    private BigDecimal amount;
}

