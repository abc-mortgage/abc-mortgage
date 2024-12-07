package com.abc.bank.mortgage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
@ResponseStatus(value= HttpStatus.NOT_FOUND)

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(){
        super();
    }
    public ResourceNotFoundException(final String messaage){
        super(messaage);
    }
}
