package com.cgnexus.example_19.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Slf4j
@Component
@Aspect
public class LoggerAspect {

    @Around("execution(* com.cgnexus.example_19..*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("{} method execution start 🏃‍♀️‍➡️", joinPoint.getSignature().toString());
        Instant start = Instant.now();
        Object returnObject = joinPoint.proceed();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        log.info("Time took to execute {} method is {}ms", joinPoint.getSignature().toString(), timeElapsed);
        log.info("{} method execution end ✅‍", joinPoint.getSignature().toString());

        return returnObject;
    }

    @AfterThrowing(value = "execution(* com.cgnexus.example_19.*.*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        log.error("{} An Exception happened 😭😭😭😭😭 due to : {}", joinPoint.getSignature(), ex.getMessage());
    }

}
