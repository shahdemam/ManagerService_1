package com.example.ManagerService.Aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j

public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.example.ManagerService.Services.TaskService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Calling method: {} with arguments: {}", joinPoint.getSignature(), joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "execution(* com.example.ManagerService.Services.TaskService.*(..))", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        logger.info("Method {} returned: {}", joinPoint.getSignature(), result);
    }
}
