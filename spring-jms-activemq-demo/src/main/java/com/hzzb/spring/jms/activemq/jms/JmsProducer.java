package com.hzzb.spring.jms.activemq.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Component;

@Component
public class JmsProducer {
	
	@Autowired
	private JmsOperations jmsOperations;
	
	public void sendMessage(String msg) {
		jmsOperations.convertAndSend("helloworld", msg);
	}
	
}
