package com.abc.bank.mortgage.controller;

import com.abc.bank.mortgage.Service.BankingService;
import com.abc.bank.mortgage.dto.AccountDetailsDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Accounts")
public class AccountController {

    @Autowired
    BankingService bankingService;

    @GetMapping("/getAccountDetails")
    public ResponseEntity<?> getAccountDetails(@RequestParam @Valid Long customerId){
         AccountDetailsDto accountDetails = bankingService.getAccountDetails(customerId);
         if(accountDetails!=null){
             return new ResponseEntity<>(accountDetails, HttpStatus.OK);
         }else{
             return new ResponseEntity<>("No Such Account Found", HttpStatus.OK);
         }
    }
}
