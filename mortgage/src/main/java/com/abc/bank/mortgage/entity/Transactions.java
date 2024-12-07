package com.abc.bank.mortgage.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    private Long fromAccount;
    private Long toAccount;
    private double amount;
    private String remark;
    private String transactionStatus;
    private LocalDate transactionDate;
}
