package com.abc.bank.mortgage.dto;

import com.abc.bank.mortgage.validation.annotations.NotEmpty;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDate;

@Data
public class TransactionsDto {

    @Id
    private Long transactionId;
    @NotEmpty
    private Long fromAccount;
    @NotEmpty
    private Long toAccount;
    @NotEmpty
    private double amount;
    private String remark;
    private String transactionStatus;
    @NotEmpty
    private LocalDate transactionDate;
}
