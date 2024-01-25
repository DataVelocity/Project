package com.cms.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Component
@Aspect
@Slf4j
public class LoggingAspect {
	 private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Before("execution(* com.cms.service.*.*(..))")
    public void logMethodStart(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        log.info("The method '{}' has started.", methodName);
    }

    @AfterReturning(pointcut = "execution(* com.cms.service.*.*(..))", returning = "result")
    public void logMethodSuccess(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        log.info("The method '{}' has completed successfully. Result: {}", methodName, result);
    }

    @AfterThrowing(pointcut = "execution(* com.cms.service.*.*(..))", throwing = "exception")
    public void logMethodException(JoinPoint joinPoint, Exception exception) {
        String methodName = joinPoint.getSignature().getName();
        log.error("Exception occurred in method '{}': {}", methodName, exception.getMessage());
    }

}
