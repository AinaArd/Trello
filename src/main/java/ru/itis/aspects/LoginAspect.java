package ru.itis.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Date;

@Aspect
@Configuration
public class LoginAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoginAspect.class);

    @Before("execution (* *..UserService.register(..))")
    public void logRegistration(JoinPoint joinPoint) {
        logger.info(Arrays.toString(joinPoint.getArgs()) + "registered successfully");
    }
}