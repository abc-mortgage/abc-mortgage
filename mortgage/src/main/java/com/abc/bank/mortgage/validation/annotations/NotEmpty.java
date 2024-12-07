package com.abc.bank.mortgage.validation.annotations;

import com.abc.bank.mortgage.validation.requestValidation.NotEmptyValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NotEmptyValidator.class)
public @interface NotEmpty {

    public String message() default "field is mandatory";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};

}
