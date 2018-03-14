package com.hzzb.spring.rabbitmq.demo.producer;

import org.springframework.amqp.rabbit.core.RabbitOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hzzb.spring.rabbitmq.demo.bean.Bread;

@Component
public class BreadProducer {
	
	@Autowired
	private RabbitOperations rabbitOperations;
	
	public void sendBread(Bread bread) {
		rabbitOperations.convertAndSend("breadExchange", "bread", bread);
	}
	
}
