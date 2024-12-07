package com.abc.bank.mortgage.dto;


import java.io.Serializable;
import java.util.Date;


public class AccountDetailsDto implements Serializable {
    public Long accountNoId;

    public Long customerId;

    public String accountType;

    public Double balance;

    public Date updateDate;

    public Date createdDate;

    public Long getAccountNoId() {
        return accountNoId;
    }

    public void setAccountNoId(Long accountNoId) {
        this.accountNoId = accountNoId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
