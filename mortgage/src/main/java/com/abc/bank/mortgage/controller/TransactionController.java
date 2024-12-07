package com.abc.bank.mortgage.controller;

import com.abc.bank.mortgage.Service.BankingService;
import com.abc.bank.mortgage.constants.ResponseMessage;
import com.abc.bank.mortgage.dto.TransactionDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    BankingService bankingService;

    @PostMapping("/insert")
    public ResponseEntity<ResponseMessage> transactiondetails(@RequestBody @Valid TransactionDto transactionReq){
        ResponseMessage responseMessage = bankingService.insertTransactions(transactionReq);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

}
