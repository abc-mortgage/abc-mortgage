package com.abc.bank.mortgage.service;

import com.abc.bank.mortgage.dto.CustomerDto;
import com.abc.bank.mortgage.entity.Customer;
import com.abc.bank.mortgage.exception.CustomerNotFoundException;
import com.abc.bank.mortgage.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankingService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerDto getCustomerDetails(Long customerId) {
        Customer customer=  customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + customerId));

        CustomerDto customerDTO = new CustomerDto();
        customerDTO.setCustomerId(customer.getCustomerId());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setDateOfBirth(customer.getDateOfBirth());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhoneNumber(customer.getPhoneNumber());
        customerDTO.setGender(customer.getGender());

        return customerDTO;
    }

}
