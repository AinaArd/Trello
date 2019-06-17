//package ru.itis.validation;
//
//import javax.validation.Constraint;
//import javax.validation.Payload;
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
//@Constraint(validatedBy = LoginValidator.class)
//@Target({ElementType.FIELD})
//@Retention(RetentionPolicy.RUNTIME)
//public @interface Login {
//    String message() default "{Login.default.message}";
//    Class<?>[] groups() default {};
//    Class<? extends Payload>[] payload() default {};
//}
