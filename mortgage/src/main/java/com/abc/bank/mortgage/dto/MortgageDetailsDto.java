package com.abc.bank.mortgage.dto;

import com.abc.bank.mortgage.validation.annotations.NotEmpty;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDate;

@Data
public class MortgageDetailsDto {

    @Id
    private Long MortgageNoId;
    @NotEmpty
    private Long customerId;
    @NotEmpty
    private Long accountNoId;
    @NotEmpty
    private String mortgageType;
    @NotEmpty
    private double propertyCost;
    private double mortgageBalance;
    private double mortgageDepositAmount;
    @NotEmpty
    private LocalDate createdDate;
}
