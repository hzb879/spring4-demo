package com.hzzb.spring.rmi.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.hzzb.spring.rmi.client.rmi.HelloService;

@Configuration
@ComponentScan
public class Application {
	
	@SuppressWarnings({ "resource" })
	public static void main(String[] args) {
		AnnotationConfigApplicationContext atx = new AnnotationConfigApplicationContext(Application.class);
		HelloService helloService = atx.getBean(HelloService.class);
		System.out.println(helloService.hello("你好"));
	}
}
