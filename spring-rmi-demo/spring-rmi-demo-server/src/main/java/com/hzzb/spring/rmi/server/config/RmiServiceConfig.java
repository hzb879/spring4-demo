package com.hzzb.spring.rmi.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.hzzb.spring.rmi.server.service.HelloService;

@Configuration
public class RmiServiceConfig {
	
	@Bean
	RmiServiceExporter rmiServiceExporter(HelloService helloService) {
		RmiServiceExporter exporter = new RmiServiceExporter();
		exporter.setService(helloService);
		exporter.setServiceInterface(HelloService.class);
		exporter.setServiceName("helloService");
		exporter.setRegistryPort(8088);
		return exporter;
	}
}
