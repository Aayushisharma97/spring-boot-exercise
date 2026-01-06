package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.example.demo.controller..*(..)) || execution(* com.example.demo.service..*(..))")
    public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();

        log.info("Entering method: {} with arguments: {}", methodName, Arrays.toString(args));

        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long duration = System.currentTimeMillis() - start;

        log.info("Exiting method: {} | Execution time: {} ms | Return: {}", methodName, duration, result);

        return result;
    }
}
