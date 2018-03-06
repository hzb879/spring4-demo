package com.hzzb.spring.jpa.demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.hzzb.spring.jpa.demo.entity.Person;
import com.hzzb.spring.jpa.demo.repository.PersonRepository;

@Configuration
@ComponentScan
public class Application {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext atx = new AnnotationConfigApplicationContext(Application.class);
		PersonRepository personRepository = atx.getBean(PersonRepository.class);
		List<Person> all = personRepository.findAll();
		System.out.println(all);
		
	}
	
}
