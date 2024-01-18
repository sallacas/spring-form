package com.springform.app.validators;

import com.springform.app.models.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        // User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"firstname","NotEmpty.user.firstname");
        /*if (!user.getId().matches("\\d{6}-[A-Z]")){
            errors.rejectValue("id","Pattern.user.id");
        }*/
    }

}
