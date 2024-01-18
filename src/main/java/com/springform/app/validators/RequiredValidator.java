package com.springform.app.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

import java.util.Objects;

public class RequiredValidator implements ConstraintValidator<Required, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {
        return !Objects.isNull(s) && StringUtils.hasText(s);
    }
}
