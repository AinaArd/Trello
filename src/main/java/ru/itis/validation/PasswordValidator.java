package ru.itis.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    @Override
    public void initialize(Password constraintAnnotation) {

    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        return correct(password, constraintValidatorContext);
    }

    private boolean correct(String password, ConstraintValidatorContext context) {
        String pattern = "^[a-zA-Z0-9]{5,30}$";
        Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(password);
        if (m.matches()) {
            return true;
        } else {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Password should contain from 3 to 30 characters and consist of letters and numbers")
                    .addConstraintViolation();
            return false;
        }
    }
}
