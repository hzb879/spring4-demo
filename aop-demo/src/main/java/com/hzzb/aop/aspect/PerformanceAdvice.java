package com.hzzb.aop.aspect;

import org.springframework.stereotype.Component;

@Component
public class PerformanceAdvice {
	
	public void doBefore(String param) {
		System.out.println("...之前做一些事..." + param);
	}
	
	public void doAfterRetuning(String result) {
		System.out.println("...doAfterRetuning之后做一些事..." + result);
	}
	
	public void doAfterThrowing() {
		System.out.println("发生异常了...");
	}
	
}
