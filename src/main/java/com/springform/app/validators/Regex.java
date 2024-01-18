package com.springform.app.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RegexValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
public @interface Regex {
    String message() default "The ID must have 6 numbers each between 0 and 9 followed by a dash and a capital letter.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
