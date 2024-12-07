package com.abc.bank.mortgage.validation.requestValidation;

import com.abc.bank.mortgage.validation.annotations.NotEmpty;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


import java.util.Collection;
import java.util.Map;

public class NotEmptyValidator implements ConstraintValidator<NotEmpty,Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        if (value instanceof String) {
            return !((String) value).trim().isEmpty();
        }

        if (value instanceof Collection) {
            return !((Collection<?>) value).isEmpty();
        }

        if (value instanceof Map) {
            return !((Map<?, ?>) value).isEmpty();
        }
        return true;
    }
}
