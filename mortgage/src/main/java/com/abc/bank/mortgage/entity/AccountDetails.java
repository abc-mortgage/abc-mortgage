package com.abc.bank.mortgage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ACCOUNTS")
public class AccountDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNoId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerInfo customerInfo;

    @Column(name="account_type")
    private String accountType;
    @Column(name="balance")
    private Double balance;
    @Column(name="update_date")
    private Date updateDate;
    @Column(name="created_date")
    private Date createdDate;

    @OneToMany(mappedBy = "accountDetails", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<MortgageDetails> mortgages;

    @OneToMany(mappedBy = "fromAccountDetails", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Transactions> fromTransactions;

    @OneToMany(mappedBy = "toAccountDetails", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Transactions> toTransactions;

    public Long getAccountNoId() {
        return accountNoId;
    }

    public void setAccountNoId(Long accountNoId) {
        this.accountNoId = accountNoId;
    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
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

    public List<MortgageDetails> getMortgages() {
        return mortgages;
    }

    public void setMortgages(List<MortgageDetails> mortgages) {
        this.mortgages = mortgages;
    }

    public List<Transactions> getFromTransactions() {
        return fromTransactions;
    }

    public void setFromTransactions(List<Transactions> fromTransactions) {
        this.fromTransactions = fromTransactions;
    }

    public List<Transactions> getToTransactions() {
        return toTransactions;
    }

    public void setToTransactions(List<Transactions> toTransactions) {
        this.toTransactions = toTransactions;
    }
}
