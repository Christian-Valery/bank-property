package com.evaluation.bankProperty.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="documenttype")
public class DocumentTypeEntity {

    private static final long SerialVersionUID =  1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="iddocumenttype")
    private int idDocumentType;

    @Column(name = "documenttype")
    private String documentType;
}
