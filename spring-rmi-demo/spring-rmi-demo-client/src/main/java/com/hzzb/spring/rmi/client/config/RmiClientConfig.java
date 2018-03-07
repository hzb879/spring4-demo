package com.hzzb.spring.rmi.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import com.hzzb.spring.rmi.client.rmi.HelloService;

@Configuration
public class RmiClientConfig {
	
	@Bean
	RmiProxyFactoryBean rmiProxyFactoryBean() {
		RmiProxyFactoryBean proxyFactoryBean = new RmiProxyFactoryBean();
		proxyFactoryBean.setServiceUrl("rmi://localhost:8088/helloService");
		proxyFactoryBean.setServiceInterface(HelloService.class);
		return proxyFactoryBean;
	}
	
}
