package com.hzzb.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.hzzb.aop.service.Performance;

@Configuration
@ComponentScan
//@EnableAspectJAutoProxy
@ImportResource("classpath:aop-config.xml")
public class Application {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext atx = new AnnotationConfigApplicationContext(Application.class);
		Performance bean = atx.getBean(Performance.class);
		bean.dance("哈哈哈哈嘻嘻嘻嘻");
	}
}
