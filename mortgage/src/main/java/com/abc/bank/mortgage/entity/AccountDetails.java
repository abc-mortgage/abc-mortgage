package com.abc.bank.mortgage.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class AccountDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNoId;
    private Long customerId;
    private String accountType;
    private double balance;
    private LocalDate updateDate;
    private LocalDate createdDate;
}
