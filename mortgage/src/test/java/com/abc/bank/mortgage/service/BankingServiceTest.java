package com.abc.bank.mortgage.service;

import com.abc.bank.mortgage.dto.CustomerDto;
import com.abc.bank.mortgage.entity.Customer;
import com.abc.bank.mortgage.exception.CustomerNotFoundException;
import com.abc.bank.mortgage.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

public class BankingServiceTest {
    @InjectMocks
    private BankingService bankingService; // Class under test

    @Mock
    private CustomerRepository customerRepository; // Mock dependency

    public BankingServiceTest() {
        openMocks(this); // Initialize mocks
    }

    @Test
    void testGetCustomerDetails_WhenCustomerExists() {
        // Arrange
        Long customerId = 101L;
        CustomerDto mockCustomerDTO = new CustomerDto();
        mockCustomerDTO.setCustomerId(customerId);
        mockCustomerDTO.setFirstName("Nan");
        mockCustomerDTO.setLastName("Ana");
        mockCustomerDTO.setDateOfBirth(LocalDate.of(2000, 1, 1));
        mockCustomerDTO.setEmail("nan_ana@gmail.com");

        // Convert CustomerDTO to Customer entity (can be done manually or via a mapping library like MapStruct)
        Customer mockCustomer = new Customer();
        mockCustomer.setCustomerId(customerId);
        mockCustomer.setFirstName("Nan");
        mockCustomer.setLastName("Ana");
        mockCustomer.setDateOfBirth(LocalDate.of(2000, 1, 1));
        mockCustomer.setEmail("nan_ana@gmail.com");

        // Mock the repository to return the customer entity
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(mockCustomer));

        // Act: Call the service method
        CustomerDto result = bankingService.getCustomerDetails(customerId);

        // Assert
        assertNotNull(result);
        assertEquals(customerId, result.getCustomerId());
        assertEquals("Nan", result.getFirstName());
        verify(customerRepository, times(1)).findById(customerId);
    }

    @Test
    void testGetCustomerDetails_WhenCustomerDoesNotExist() {
        // Arrange
        Long customerId = 103L;
        when(customerRepository.findById(customerId)).thenReturn(Optional.empty());

        // Act & Assert
        Exception exception = assertThrows(CustomerNotFoundException.class, () -> {
            bankingService.getCustomerDetails(customerId);
        });

        assertEquals("Customer not found with ID: 102", exception.getMessage());
        verify(customerRepository, times(1)).findById(customerId);
    }
}
