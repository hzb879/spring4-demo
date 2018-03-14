package com.hzzb.spring.rabbitmq.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.hzzb.spring.rabbitmq.demo.bean.Bread;
import com.hzzb.spring.rabbitmq.demo.producer.BreadProducer;

@Configuration
@ComponentScan
@ImportResource({ "classpath:rabbitmq-config.xml" })
public class Application {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext atx = new AnnotationConfigApplicationContext(Application.class);
		BreadProducer breadProducer = atx.getBean(BreadProducer.class);
		boolean flag = false;
		for (int i = 0; i < 10; i++) {
			if( i % 2 == 0) {
				flag = false;
			}else {
				flag = true;
			}
			breadProducer.sendBread(new Bread("面包" + i, i, flag));
		}
	}
}
