package com.abc.bank.mortgage.validation.annotations;

import com.abc.bank.mortgage.validation.requestValidation.NotEmptyValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NotEmptyValidator.class) // Links to the validator class
@Target({ElementType.FIELD, ElementType.METHOD}) // Applicable to fields and methods
@Retention(RetentionPolicy.RUNTIME) // Retain at runtime
public @interface NotEmpty {
    String message() default "This field must not be empty"; // Default error message

    Class<?>[] groups() default {}; // Used for grouping constraints

    Class<? extends Payload>[] payload() default {}; // Additional metadata
}