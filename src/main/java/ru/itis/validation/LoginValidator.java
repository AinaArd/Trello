package ru.itis.validation;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.services.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginValidator implements ConstraintValidator<Login, String> {

    private UserService userService;

    @Autowired
    public LoginValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(Login constraintAnnotation) {

    }

    @Override
    public boolean isValid(String login, ConstraintValidatorContext constraintValidatorContext) {
        return isUnique(login, constraintValidatorContext) && correct(login, constraintValidatorContext);
    }

    private boolean isUnique(String login, ConstraintValidatorContext constraintValidatorContext){
        if(!userService.checkForUniqueness(login)) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("Login is already in use")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }

    private boolean correct(String login, ConstraintValidatorContext constraintValidatorContext) {
        String pattern = "^([a-z0-9_\\.-]+)@([a-z0-9_\\.-]+)\\.([a-z\\.]{2,6})$";
        Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(login);
        if (!m.matches()) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("Incorrect login")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
