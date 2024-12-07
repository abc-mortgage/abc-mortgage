package com.abc.bank.mortgage.entity;


import jakarta.persistence.*;


import java.util.Date;


@Entity
@Table(name = "TRANSACTIONS")

public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "from_account", nullable = false)
    private AccountDetails fromAccountDetails;
    @ManyToOne
    @JoinColumn(name = "to_account", nullable = false)
    private AccountDetails toAccountDetails;

    @Column(name="amount")
    public Double amount;

    @Column(name="remarks")
    public String remarks;
    @Column(name="transaction_status")
    public String transactionStatus;
    @Column(name="transaction_date")
    public Date transactionDate;


    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public AccountDetails getFromAccountDetails() {
        return fromAccountDetails;
    }

    public void setFromAccountDetails(AccountDetails fromAccountDetails) {
        this.fromAccountDetails = fromAccountDetails;
    }

    public AccountDetails getToAccountDetails() {
        return toAccountDetails;
    }

    public void setToAccountDetails(AccountDetails toAccountDetails) {
        this.toAccountDetails = toAccountDetails;
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

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
