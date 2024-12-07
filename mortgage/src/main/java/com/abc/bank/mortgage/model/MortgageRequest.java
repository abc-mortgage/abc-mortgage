package com.abc.bank.mortgage.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MortgageRequest implements Serializable {
    private Long mortgageId;
    @Valid
    @NotNull(message = "Customer value cannot be blank")
    private Long customer_id;
    @NotNull(message = "Account number cannot be blank")
    private Integer account_no;
    @NotNull(message = "Mortgage type cannot be blank")
    private String mortgage_type;
    @NotNull(message = "Property cost cannot be blank")
    private Integer property_cost;
    @NotNull(message = "Mortgage balance cannot be blank")
    private Integer mortgage_balance;
    @NotNull(message = "Mortgage deposit amount cannot be blank")
    private Integer mortgage_deposit_amount;
    @NotNull(message = "Created date cannot be null")
    @Future(message = "Event date must be in the future")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date created_at;




}
