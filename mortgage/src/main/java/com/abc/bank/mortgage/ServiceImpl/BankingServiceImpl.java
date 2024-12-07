package com.abc.bank.mortgage.ServiceImpl;

import com.abc.bank.mortgage.Service.BankingService;
import com.abc.bank.mortgage.constants.ResponseMessage;
import com.abc.bank.mortgage.dto.AccountDetailsDto;
import com.abc.bank.mortgage.dto.TransactionDto;
import com.abc.bank.mortgage.entity.AccountDetails;
import com.abc.bank.mortgage.entity.Transactions;
import com.abc.bank.mortgage.repository.AccountDetailsRepository;
import com.abc.bank.mortgage.repository.TransactionsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BankingServiceImpl implements BankingService {

    @Autowired
    AccountDetailsRepository accountDetailsRepository;

    @Autowired
    TransactionsRepository transactionsRepository;

    @Override
    public ResponseMessage insertTransactions(TransactionDto transactionDto) {
        ResponseMessage responseMessage= insertTransactionDetails(transactionDto);
        return responseMessage;
    }

    @Override
    public AccountDetailsDto getAccountDetails(Long customerId) {
        Optional<AccountDetails> accountDetails = accountDetailsRepository.findById(customerId);
        if(accountDetails.isPresent()){
            return getAccountDetailsDto(accountDetails.get());
        }else{
            return null;
        }
    }

    private AccountDetailsDto getAccountDetailsDto(AccountDetails accountDetails) {
          AccountDetailsDto accountDetailsDto = new AccountDetailsDto();
          accountDetailsDto.setCustomerId(accountDetails.getCustomerInfo().getCustomerId());
          BeanUtils.copyProperties(accountDetails,accountDetailsDto);
          return accountDetailsDto;

    }


    private ResponseMessage insertTransactionDetails(TransactionDto transactionDto) {
        ResponseMessage responseMessage = new ResponseMessage();
        String str = "";
        List<ResponseMessage> responseMessageList = validateAccountDetails(transactionDto);
        if(responseMessageList.size()>0){
            str=responseMessageList.stream()
                    .map(ResponseMessage::getMessage)
                    .collect(Collectors.joining(", "));
             responseMessage.setMessage(str);
        }else{
            str = persistTransactionDetails(transactionDto);
            responseMessage.setMessage(str);
        }

        return responseMessage;
    }

    private String persistTransactionDetails(TransactionDto transactionDto) {
            Transactions transactions = new Transactions();
            try {
                transactions.setAmount(transactionDto.getAmount());
                transactions.setTransactionDate(new Date());
                transactions.setRemarks(transactionDto.getRemarks());
                Optional<AccountDetails> toAccountDetails = accountDetailsRepository.
                        findById(Long.parseLong(transactionDto.getToAccount()));
                transactions.setToAccountDetails(toAccountDetails.get());
                Optional<AccountDetails> fromAccountDetails = accountDetailsRepository.
                        findById(Long.parseLong(transactionDto.getFromAccount()));
                transactions.setFromAccountDetails(fromAccountDetails.get());
                transactions.setTransactionStatus("SUCCESS");
                transactionsRepository.save(transactions);
            }catch(Exception e){
                return "Transaction failed";
            }
            return "Transaction Success";
    }

    private List<ResponseMessage> validateAccountDetails(TransactionDto transactionDto) {
        Optional<AccountDetails> fromAccountDetails = accountDetailsRepository.
                findById(Long.parseLong(transactionDto.getFromAccount()));
        List<ResponseMessage> responseMessageList = new ArrayList<>();
        if(transactionDto.getFromAccount().equals(transactionDto.getToAccount())){
            ResponseMessage responseMessage = new ResponseMessage();
            responseMessage.setMessage("From Account No and To Account No Cannot be Same");
            responseMessageList.add(responseMessage);
        }
        if(!fromAccountDetails.isPresent()){
            ResponseMessage responseMessage = new ResponseMessage();
            responseMessage.setMessage("please give the correct from account");
            responseMessageList.add(responseMessage);
        }
        Optional<AccountDetails> toAccountDetails = accountDetailsRepository.
                findById(Long.parseLong(transactionDto.getToAccount()));
        if(!toAccountDetails.isPresent()){
            ResponseMessage responseMessage = new ResponseMessage();
            responseMessage.setMessage("please give the correct to account");
            responseMessageList.add(responseMessage);
        }
        if(transactionDto.getAmount()<=0){
            ResponseMessage responseMessage = new ResponseMessage();
            responseMessage.setMessage("please give valid amount");
            responseMessageList.add(responseMessage);
        }
        if(toAccountDetails.isPresent() && toAccountDetails.get().getBalance()<transactionDto.getAmount()){
            ResponseMessage responseMessage = new ResponseMessage();
            responseMessage.setMessage("amount should not greater than to Accounts bankbalance");
            responseMessageList.add(responseMessage);

        }
        return  responseMessageList;
    }
}
