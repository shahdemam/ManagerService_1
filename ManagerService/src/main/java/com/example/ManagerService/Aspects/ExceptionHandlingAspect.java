package com.example.ManagerService.Aspects;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionHandlingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @AfterThrowing(pointcut = "execution(* com.example.ManagerService.Services.TaskService.*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Throwable ex) {
        logger.error("Exception in method: {} with message: {}", joinPoint.getSignature(), ex.getMessage());
    }
}
