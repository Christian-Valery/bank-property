package com.evaluation.bankProperty.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "facilitydetails")
public class FacilityDetailsEntity {
    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idfacilitydetails")
    private int idFacilityDetails;

    @ManyToOne
    @JoinColumn(name = "fk_facilitydetailstype_id")
    private FacilityDetailsTypeEntity facilityDetailsTypeEntity;

    @ManyToOne
    @JoinColumn(name = "fk_facilitydetailscategory_id")
    private FacilityDetailsCategoryEntity facilityDetailsCategoryEntity;

    @ManyToOne
    @JoinColumn(name = "fk_facilitydetailspurpose_id")
    private FacilityDetailsPurposeEntity facilityDetailsPurposeEntity;

    @Column(name = "term")
    private int term;

    @ManyToOne
    @JoinColumn(name = "fk_facilitydetailsCCY_id")
    private FacilityDetailsCCYEntity facilityDetailsCCYEntity;

    @Column(name = "amount")
    private BigDecimal amount;
}
