package com.explore.spring.aop.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static Logger myLogger= Logger.getLogger(LoggingAspect.class.getName());
	
	@Around("execution(* com.explore.spring.aop.services.TrafficFortuneService.getFortune(..))")
	public Object aroundGetFortuneAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		String method = proceedingJoinPoint.getSignature().toShortString();
		
		myLogger.info("Intercepted method is : "+method);
		
		long begin = System.currentTimeMillis();
		Object result = proceedingJoinPoint.proceed();
		
		long end=  System.currentTimeMillis();
		
		long duration=end-begin;
		
		myLogger.info("Duration is --->"+duration/1000.0 +"Seconds");
		
		
		
		return result;
		
	}
		

}
