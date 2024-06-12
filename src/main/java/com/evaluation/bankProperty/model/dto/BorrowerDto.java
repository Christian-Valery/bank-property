package com.evaluation.bankProperty.model.dto;

import com.evaluation.bankProperty.model.CustomerEntity;
import lombok.Data;

@Data
public class BorrowerDto {
    private CustomerEntity customer;
    private boolean isMain;
}
