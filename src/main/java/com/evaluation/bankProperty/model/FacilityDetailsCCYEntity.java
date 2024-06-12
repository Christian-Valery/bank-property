package com.evaluation.bankProperty.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "facilitydetailsCCY")
public class FacilityDetailsCCYEntity {
    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idfacilitydetailsCCY")
    private int idFacilityDetailsCCY;

    @Column(name = "facilitydetailsCCY")
    private String facilityDetailsCCY;
}
