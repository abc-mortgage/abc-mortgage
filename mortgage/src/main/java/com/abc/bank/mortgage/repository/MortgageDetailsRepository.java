package com.abc.bank.mortgage.repository;

import com.abc.bank.mortgage.entity.MortgageDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MortgageDetailsRepository extends JpaRepository<MortgageDetails,Long> {
}
