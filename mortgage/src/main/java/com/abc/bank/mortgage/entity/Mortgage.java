package com.abc.bank.mortgage.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="mortgage")
public class Mortgage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mortgage_id", nullable = false, updatable = false)
    private Long mortgageId;
    @Column(name = "customer_id", nullable = false, updatable = false)
    private Long customer_id;
    @Column(name = "account_no", nullable = false, updatable = false)
    private Integer account_no;
    @Column(name = "mortgage_type")
    private String mortgage_type;
    @Column(name = "property_cost")
    private Integer property_cost;
    @Column(name = "mortgage_balance")
    private Integer mortgage_balance;
    @Column(name = "mortgage_deposit_amount")
    private Integer mortgage_deposit_amount;
    @Column(name = "created_at")
    private Date created_at;




}
