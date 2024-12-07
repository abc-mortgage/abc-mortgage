package com.abc.bank.mortgage.dto;

import com.abc.bank.mortgage.validation.annotations.NotEmpty;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDate;

@Data
public class AccountDetailsDto {

    @Id
    private Long accountNoId;
    @NotEmpty
    private Long customerId;
    @NotEmpty
    private String accountType;
    @NotEmpty
    private double balance;
    @NotEmpty
    private LocalDate updateDate;
    @NotEmpty
    private LocalDate createdDate;
}
