package com.hzzb.spring.jms.activemq.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsAsyncComsumer {
		
	@JmsListener(containerFactory = "myJmsListenerContainerFactory", destination = "helloworld")
	public void process(String message) {
		System.out.println("收到异步消息: " + message);
	}
}
