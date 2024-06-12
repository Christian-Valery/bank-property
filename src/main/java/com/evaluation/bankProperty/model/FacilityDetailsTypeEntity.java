package com.evaluation.bankProperty.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="facilitydetailstype")
public class FacilityDetailsTypeEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idfacilitydetailstype")
    private int idFacilityDetailsType;

    @Column(name = "facilitydetailstype")
    private String facilityDetailsType;
}
