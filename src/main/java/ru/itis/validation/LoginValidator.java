package ru.itis.validation;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.services.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginValidator implements ConstraintValidator<Login, String> {

    @Autowired
    private UserService userService;

    public LoginValidator() {
    }

    @Override
    public void initialize(Login constraintAnnotation) {

    }

    @Override
    public boolean isValid(String login, ConstraintValidatorContext constraintValidatorContext) {
        return isUnique(login, constraintValidatorContext) && correct(login, constraintValidatorContext);
    }

    private boolean isUnique(String login, ConstraintValidatorContext constraintValidatorContext) {
        if (!userService.checkForUniqueness(login)) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("{Login.isUnique.message}")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }

    private boolean correct(String login, ConstraintValidatorContext constraintValidatorContext) {
        String pattern = "^[a-zA-Z0-9]$";
        Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(login);
        if (!m.matches()) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("{Login.matchesPattern.message}")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
