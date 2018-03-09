package com.hzzb.spring.jms.activemq.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@EnableJms
@Configuration
public class ActiveMqConfig {
	
	@Bean
	ConnectionFactory connectionFactory() {
		return new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
				ActiveMQConnectionFactory.DEFAULT_PASSWORD,
				ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
	}

	@Bean
    DefaultJmsListenerContainerFactory myJmsListenerContainerFactory() {
      DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
      factory.setConnectionFactory(connectionFactory());
      return factory;
    }
	
	@Bean
    JmsTemplate jmsTemplate() {
      return new JmsTemplate(connectionFactory());
    }
	
}
