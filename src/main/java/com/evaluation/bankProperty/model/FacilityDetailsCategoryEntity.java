package com.evaluation.bankProperty.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "facilitydetailscategory")
public class FacilityDetailsCategoryEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idfacilitydetailscategory")
    private int idFacilityDetailsCategory;

    @Column(name = "facilitydetailscategory")
    private String facilityDetailsCategory;
}
