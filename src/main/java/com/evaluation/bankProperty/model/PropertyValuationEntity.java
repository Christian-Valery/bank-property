package com.evaluation.bankProperty.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "propertyvaluation")
public class PropertyValuationEntity {
    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idpropertyvaluation")
    private int idPropertyValuation;

    @Column(name = "propertyvaluationfosref")
    private String propertyValuationFosRef;

    @ManyToOne
    @JoinColumn(name = "fk_propertyvaluationtype_id")
    private PropertyValuationTypeEntity propertyValuationTypeEntity;
}
