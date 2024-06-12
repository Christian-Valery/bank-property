package com.evaluation.bankProperty.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "customer")
public class CustomerEntity {
    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idcustomer")
    private int idCustomer;

    @Column(name = "customerNumber")
    private String customerNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "contactnumber")
    private String contactNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;
}
