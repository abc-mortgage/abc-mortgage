package com.abc.bank.mortgage.repository;

import com.abc.bank.mortgage.model.Mortgage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;
import java.util.UUID;
//@EnableJpaRepositories
public interface MortgageRepository extends JpaRepository<Mortgage, Long> {
    Optional<Mortgage> findAllByMortgageId(Long uuid);
}
