package com.abc.bank.mortgage.repository;

import com.abc.bank.mortgage.entity.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerInfoRepository extends JpaRepository<CustomerInfo,Long> {
}
