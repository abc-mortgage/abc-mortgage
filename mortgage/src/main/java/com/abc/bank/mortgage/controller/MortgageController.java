package com.abc.bank.mortgage.controller;

import com.abc.bank.mortgage.config.MessageUtil;
import com.abc.bank.mortgage.exception.ResourceNotFoundException;
import com.abc.bank.mortgage.model.Mortgage;
import com.abc.bank.mortgage.model.MortgageRequest;
import com.abc.bank.mortgage.service.MortgageService;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static com.abc.bank.mortgage.constant.MAContants.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping(DEFAULT_URI)
public class MortgageController {

    private final MortgageService mortgageService;
    private final MessageUtil messageUtil;


    @Operation(summary = "Get Mortgage Details", description = "Retrieve mortgage details")
    @GetMapping(value="/mortgage/{mortgage_id}")
    public Mortgage getById(@ApiParam(value = "the ID of the item want to view") @PathVariable("mortgage_id") String id) throws Exception {
        if(StringUtils.isEmpty(id)) throw new Exception(messageUtil.getMessages("mortgageIdNull"));
        Mortgage mortgageDetails = mortgageService.findDetailsById(Long.parseLong(id));
        if(Objects.isNull(mortgageDetails)) throw new ResourceNotFoundException("Mortgage not found");
        else return mortgageDetails;

    }

    @Operation(summary = "Create Mortgage", description = "Create mortgage")
    @PostMapping("/mortgage")
    public ResponseEntity<Mortgage> createMortgage(@RequestBody @Valid MortgageRequest mortgage) throws Exception {

        return new ResponseEntity<>(mortgageService.createMortgage(mortgage), HttpStatus.OK);
    }


}
