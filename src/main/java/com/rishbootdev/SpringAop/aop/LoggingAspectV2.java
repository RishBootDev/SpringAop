package com.rishbootdev.SpringAop.aop;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class LoggingAspectV2 {


    private final Logger LOGGER;

    @Before("allServiceMethodPointCut()")
    public void beforeServiceMethodCall(JoinPoint joinPoint){
       LOGGER.info("Before advice method call:{}",joinPoint.getSignature());
    }

    @Pointcut("execution(* com.rishbootdev.SpringAop.service.*.*(..))")
    public void allServiceMethodPointCut(){

    }

    @AfterReturning(value = "allServiceMethodPointCut()",returning = "returnedObj")
    public void logMethodAfterCall(JoinPoint joinPoint,Object returnedObj){
        LOGGER.info("hey i am throwing this error intentionally after a method call");
        LOGGER.info("hey this object is returned : {}",returnedObj);
    }

    @Around("allServiceMethodPointCut()")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        Long startTime=System.currentTimeMillis();
        Object returnedValue=proceedingJoinPoint.proceed();
        Long endTime=System.currentTimeMillis();

        Long diff=endTime-startTime;

        LOGGER.info("Time taken for {} is {}",proceedingJoinPoint.getSignature(),diff);

        return returnedValue;
    }
}


/*
    These are the following types of Advices in Spring AOP:

    1. Before ----> Runs before the target method executes.
    2. After -----> Runs after the method executes regardless of outcome (success or exception).
    3. After Returning -----> Runs only if the method completes successfully.
    4. After Throwing  -----> Runs only if the method throws an exception.
    5. Around   -------> Wraps around the method execution (before, after)

    Spring Proxy
    =============

    In Spring, a proxy is an object created by the Spring container that wraps your actual bean to add
    cross-cutting behavior (like transactions, logging, security, caching) without modifying your business logic.

    These are created only when certain conditions are met like:
    1. Aspect oriented programming is used
    2. Spring features like @Transactional, @Cacheable , @Async ,etc are used

    Different use cases of Spring AOP

    1. security aspects and logging
    2. Caching aspect
    3. Auditing aspect
    4. Exceptional Handling aspect
    5. Validating transactions
 */