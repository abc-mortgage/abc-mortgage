package com.abc.bank.mortgage.repository;

import com.abc.bank.mortgage.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TransactionsRepository extends JpaRepository<Transactions,Long> {
}
