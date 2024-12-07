package com.abc.bank.mortgage.Service;

import com.abc.bank.mortgage.constants.ResponseMessage;
import com.abc.bank.mortgage.dto.AccountDetailsDto;
import com.abc.bank.mortgage.dto.TransactionDto;


public interface BankingService {
       ResponseMessage insertTransactions(TransactionDto transactionDto);
       AccountDetailsDto getAccountDetails(Long customerId);
}
