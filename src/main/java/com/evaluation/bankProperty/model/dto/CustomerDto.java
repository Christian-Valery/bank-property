package com.evaluation.bankProperty.model.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CustomerDto {
    private String customerNumber;
    private String name;
    private String contactNumber;
    private String email;
    private String address;
}
