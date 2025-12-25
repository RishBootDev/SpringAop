package com.rishbootdev.SpringAop.aop;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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

}
