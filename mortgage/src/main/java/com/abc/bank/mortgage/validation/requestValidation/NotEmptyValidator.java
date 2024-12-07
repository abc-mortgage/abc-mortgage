package com.abc.bank.mortgage.validation.requestValidation;

import com.abc.bank.mortgage.validation.annotations.NotEmpty;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotEmptyValidator  implements ConstraintValidator<NotEmpty, Object>{

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        // Check if the value is not null
        if (value == null) {
            return false;
        }
        if (value instanceof String) {
            return !((String) value).trim().isEmpty();
        }
        return true;
    }

}
