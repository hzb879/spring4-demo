package com.hzzb.spring.cache;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.hzzb.spring.cache.demo.User;
import com.hzzb.spring.cache.demo.UserService;

@EnableCaching
@Configuration
@ComponentScan
public class Application {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException {
		AnnotationConfigApplicationContext atx = new AnnotationConfigApplicationContext(Application.class);
		UserService userService = atx.getBean(UserService.class);
		userService.save(new User(null, "哈哈", 5));
		System.out.println(userService.get(1));
		System.out.println(userService.get(2));
		System.out.println(userService.get(3));
		System.out.println(userService.get(2));
		System.out.println(userService.get(1));
		TimeUnit.SECONDS.sleep(2);
		System.out.println(userService.get(1));
		System.out.println(userService.get(1));
	}
}
