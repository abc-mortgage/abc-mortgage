package com.abc.bank.mortgage.controller;

import com.abc.bank.mortgage.dto.CustomerDto;
import com.abc.bank.mortgage.entity.Customer;
import com.abc.bank.mortgage.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private BankingService bankingService;

//    @GetMapping("/details")
    //it will return 200-Ok status on Succeed
//    public ResponseEntity<Customer> getCustomerDetails(@RequestParam Long customerId) {
//        Customer customer = bankingService.getCustomerDetails(customerId);
//        return ResponseEntity.ok(customer);
//    }

    @GetMapping("/details")
    public CustomerDto getCustomerDetails(@RequestParam Long customerId) {
        return bankingService.getCustomerDetails(customerId); // Return DTO
    }
}
