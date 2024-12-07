package com.abc.bank.mortgage.dto;

import com.abc.bank.mortgage.validation.annotations.NotEmpty;
import jakarta.validation.Valid;


import java.io.Serializable;


@Valid
public class TransactionDto implements Serializable {

    @NotEmpty
    public String fromAccount;
    @NotEmpty
    public String toAccount;
    @NotEmpty
    public Double amount;
    @NotEmpty
    public String remarks;

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
