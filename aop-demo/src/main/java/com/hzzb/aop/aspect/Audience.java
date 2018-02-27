package com.hzzb.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Audience {
	
	@Pointcut("execution(** com.hzzb.aop.service.Performance.perform(..))")
	public void perform() {}
	
	@Pointcut("execution(** com.hzzb.aop.service.Performance.dance(String))"
			+ " && args(param)")
	public void dance(String param) {}
	
	
	@Before("dance(param1)")
	public void danceBefore(String param1) {
		System.out.println("拿到dance参数...." + param1);
	}
	
	@Around("perform()")
	public void around(ProceedingJoinPoint jp) {
		try {
			System.out.println("表演之前做点事...");
			Object result = jp.proceed();
			System.out.println("表演result: " + result);
			System.out.println("表演之后做点事...");
		} catch (Throwable e) {
			System.out.println("表演异常了...");
		}
	}
	
}
