package com.abc.bank.mortgage.service;

import com.abc.bank.mortgage.mapper.MortgageMapper;
import com.abc.bank.mortgage.model.Mortgage;
import com.abc.bank.mortgage.model.MortgageRequest;
import com.abc.bank.mortgage.repository.MortgageRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class MortgageService {

    private final MortgageRepository mortgageRepository;
    private final MortgageMapper mortgageMapper;

    public Mortgage findDetailsById(Long id) {
        Optional<Mortgage> mortgage=mortgageRepository.findById(id);
        if(mortgage.isPresent()) return mortgage.get();
        else return null;
    }

    @Transactional
    public Mortgage createMortgage(MortgageRequest mortgage) {
        return mortgageRepository.save(mortgageMapper.mortgageDTOToEntity(mortgage));
    }
}
