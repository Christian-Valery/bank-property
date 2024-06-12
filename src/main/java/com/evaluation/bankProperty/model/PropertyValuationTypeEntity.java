package com.evaluation.bankProperty.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "propertyvaluationtype")
public class PropertyValuationTypeEntity {
    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idpropertyvaluationtype")
    private int idPropertyValuationType;

    @Column(name = "propertyvaluationtype")
    private String propertyValuationType;
}
