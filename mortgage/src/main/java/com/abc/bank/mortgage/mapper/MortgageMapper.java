package com.abc.bank.mortgage.mapper;

import com.abc.bank.mortgage.model.Mortgage;
import com.abc.bank.mortgage.model.MortgageRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Date;

@Mapper(componentModel = "spring")
public interface MortgageMapper {

    @Mapping(source = "mortgageId", target = "mortgageId")
    @Mapping(source = "customer_id", target = "customer_id")
    @Mapping(source = "account_no", target = "account_no")
    @Mapping(source = "mortgage_type", target = "mortgage_type")
    @Mapping(source = "property_cost", target = "property_cost")
    @Mapping(source = "mortgage_balance", target = "mortgage_balance")
    @Mapping(source = "mortgage_deposit_amount", target = "mortgage_deposit_amount")
    @Mapping(source = "created_at", target = "created_at")
    Mortgage mortgageDTOToEntity(MortgageRequest mortgageRequest);
}
