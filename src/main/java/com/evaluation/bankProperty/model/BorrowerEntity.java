package com.evaluation.bankProperty.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "borrower")
public class BorrowerEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idborrower")
    private int idBorrower;

    @OneToOne
    @JoinColumn(name = "fk_customer_id")
    private CustomerEntity customer;

    @Column(name = "ismain")
    private boolean isMain;
}
