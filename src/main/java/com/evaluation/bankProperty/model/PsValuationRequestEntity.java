package com.evaluation.bankProperty.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "pvsvaluationrequest")
public class PsValuationRequestEntity {
    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idpvsvaluationrequest")
    private int idPvsValuationRequest;

    @Column(name = "pvvaluationrequestreference")
    private String pvValuationRequestReference;

    @Column(name = "receivingdate")
    private LocalDateTime receivingDate;

    @ManyToOne
    @JoinColumn(name = "fk_borrower_id")
    private BorrowerEntity borrowerEntity;

    @ManyToOne
    @JoinColumn(name = "fk_propertyvaluation_id")
    private PropertyValuationEntity propertyValuationEntity;

    @Column(name = "creationdate")
    private LocalDateTime creationDate;

    @Column(name = "modificationdate")
    private LocalDateTime modificationDate;
}
