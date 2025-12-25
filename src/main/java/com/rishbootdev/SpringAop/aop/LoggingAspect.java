package com.rishbootdev.SpringAop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Slf4j
@Component
public class LoggingAspect {

    private static final Logger LOGGER= LoggerFactory.getLogger(LoggingAspect.class);


    @Before("execution(* com.rishbootdev.SpringAop.service.PersonService.*(..))")
    public void logMethodCall(JoinPoint joinPoint){

        LOGGER.info("the method body to be called will be :{}",joinPoint.getSignature());
        LOGGER.info("method called");
    }

}
