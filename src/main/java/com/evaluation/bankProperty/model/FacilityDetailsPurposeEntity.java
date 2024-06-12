package com.evaluation.bankProperty.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "facilitydetailspurpose")
public class FacilityDetailsPurposeEntity {

    private static final long SerialUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idfacilitydetailspurpose")
    private int idFacilityDetailsPurpose;

    @Column(name = "facilitydetailspurpose")
    private String facilityDetailsPurpose;
}
