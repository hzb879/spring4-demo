package com.hzzb.spring.jms.activemq.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Component;

@Component
public class JmsBlockingComsumer {
		
	@Autowired
	private JmsOperations jmsOperations;
	
	public String getMessage() {
		return (String) jmsOperations.receiveAndConvert("helloworld");
	}
}
