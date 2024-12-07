package com.abc.bank.mortgage.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.abc.bank.mortgage.mapper.MortgageMapper;
import com.abc.bank.mortgage.model.Mortgage;
import com.abc.bank.mortgage.model.MortgageRequest;
import com.abc.bank.mortgage.repository.MortgageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MortgageServiceTest {

    @Mock
    private MortgageRepository mortgageRepository;

    @Mock
    private MortgageMapper mortgageMapper;

    @InjectMocks
    private MortgageService mortgageService;

    private MortgageRequest mortgageRequest;
    private Mortgage mortgageEntity;

    @BeforeEach
    void setUp() {
        mortgageRequest = new MortgageRequest();
        mortgageRequest.setMortgage_balance(100);
        mortgageRequest.setMortgage_deposit_amount(10);

        mortgageEntity = new Mortgage();
        mortgageEntity.setMortgage_balance(100);
        mortgageEntity.setMortgage_deposit_amount(10);
    }

    @Test
    void testCreateMortgage() {
        when(mortgageMapper.mortgageDTOToEntity(mortgageRequest)).thenReturn(mortgageEntity);
        when(mortgageRepository.save(mortgageEntity)).thenReturn(mortgageEntity);
        Mortgage result = mortgageService.createMortgage(mortgageRequest);
        assertNotNull(result);
        assertEquals(100, result.getMortgage_balance());
        assertEquals(10, result.getMortgage_deposit_amount());
        verify(mortgageMapper).mortgageDTOToEntity(mortgageRequest);
        verify(mortgageRepository).save(mortgageEntity);
    }
}
