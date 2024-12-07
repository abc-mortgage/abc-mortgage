package com.abc.bank.mortgage.entity;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "MORTGAGEDETAILS")
public class MortgageDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mortgageId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerInfo customer;
    @ManyToOne
    @JoinColumn(name = "account_no_id", nullable = false)
    private AccountDetails accountDetails;

    @Column(name="mortgage_type")
    private String mortgageType;
    @Column(name="property_cost")
    private Double propertyCost;
    @Column(name="mortgage_balance")
    private Double mortgageBalance;
    @Column(name="mortgage_deposit_amount_cost")
    private Double mortgageDepositAmountConst;
    @Column(name="created_date")
    private Date createdDate;


    public Long getMortgageId() {
        return mortgageId;
    }

    public void setMortgageId(Long mortgageId) {
        this.mortgageId = mortgageId;
    }

    public CustomerInfo getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerInfo customer) {
        this.customer = customer;
    }

    public AccountDetails getAccountDetails() {
        return accountDetails;
    }

    public void setAccountDetails(AccountDetails accountDetails) {
        this.accountDetails = accountDetails;
    }

    public String getMortgageType() {
        return mortgageType;
    }

    public void setMortgageType(String mortgageType) {
        this.mortgageType = mortgageType;
    }

    public Double getPropertyCost() {
        return propertyCost;
    }

    public void setPropertyCost(Double propertyCost) {
        this.propertyCost = propertyCost;
    }

    public Double getMortgageBalance() {
        return mortgageBalance;
    }

    public void setMortgageBalance(Double mortgageBalance) {
        this.mortgageBalance = mortgageBalance;
    }

    public Double getMortgageDepositAmountConst() {
        return mortgageDepositAmountConst;
    }

    public void setMortgageDepositAmountConst(Double mortgageDepositAmountConst) {
        this.mortgageDepositAmountConst = mortgageDepositAmountConst;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
