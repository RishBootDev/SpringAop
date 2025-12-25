package com.rishbootdev.SpringAop.aop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;


@Aspect
@Slf4j
@Component
@RequiredArgsConstructor
public class LoggingAspect {

    private final Logger LOGGER;

    @Before("execution(* com.rishbootdev.SpringAop.service.PersonService.*(..))")
    public void logMethodCall(JoinPoint joinPoint){

        // this is the named pointcut method
        LOGGER.info("the method body to be called will be :{}",joinPoint.getSignature());
        LOGGER.info("the king of the method is: {}",joinPoint.getKind());
        LOGGER.info("method called");
    }

    @After("execution(* com.rishbootdev.SpringAop.service.PersonService.*(..))")
    public void logMethodAfterCall(JoinPoint joinPoint){
        LOGGER.info("hey i am throwing this error intentionally after a method call");
    }

    @Before("myLoggingAndAopMethodsPointCut()")
    public void transactionalMethods(JoinPoint joinpoint){

        // this kind of pointcut is denoted as the inline pointcut
        LOGGER.info("the method which is annotated with the @Transactional will be called");

    }

    @After("@annotation(com.rishbootdev.SpringAop.aop.MyLogging)")
    public void customAnnotationMethod(JoinPoint joinpoint){
        LOGGER.info("the method with my custom annotation called");

    }

    @Pointcut("@annotation(jakarta.transaction.Transactional)")
    public void myLoggingAndAopMethodsPointCut(){
        // this is the pointcut method
    }

}
