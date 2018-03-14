package com.hzzb.spring.rabbitmq.demo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.hzzb.spring.rabbitmq.demo.bean.Bread;

@Component
public class BreadConsumer {
	
	@RabbitListener(queues = "bread")
	public void consumeBread(Bread bread) {
		System.out.println("BreadListener 消费: " + bread);
	}
}
