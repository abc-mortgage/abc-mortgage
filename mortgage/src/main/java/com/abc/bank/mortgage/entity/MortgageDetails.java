package com.abc.bank.mortgage.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class MortgageDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long MortgageNoId;
    private Long customerId;
    private Long accountNoId;
    private String mortgageType;
    private double propertyCost;
    private double mortgageBalance;
    private double mortgageDepositAmount;
    private LocalDate createdDate;
}
