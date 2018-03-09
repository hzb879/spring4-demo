package com.hzzb.spring.jms.activemq;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.hzzb.spring.jms.activemq.jms.JmsProducer;

@Configuration
@ComponentScan
public class Application {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext atx = new AnnotationConfigApplicationContext(Application.class);
		JmsProducer jmsProducer = atx.getBean(JmsProducer.class);
		for (int i = 0; i < 10; i++) {
			jmsProducer.sendMessage("大家好 " + i);
		}
	}
}
