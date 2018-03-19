package com.hzzb.spring.mail.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.TemplateExceptionHandler;

@Configuration
@PropertySource("classpath:/mail/config.properties")
public class MailConfig {
	
	@Bean
	MailSender mailSender(Environment env) {
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		javaMailSenderImpl.setHost(env.getProperty("mail.server.host"));
		javaMailSenderImpl.setPort(Integer.valueOf(env.getProperty("mail.server.port", "25")));
		javaMailSenderImpl.setUsername(env.getProperty("mail.server.username"));
		javaMailSenderImpl.setPassword(env.getProperty("mail.server.password"));
		return javaMailSenderImpl;
	}
	
	@Bean
	freemarker.template.Configuration freemarkerConfig() {
		freemarker.template.Configuration cfg = new freemarker
				.template.Configuration(
						freemarker.template.Configuration.VERSION_2_3_23);
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateLoader(new ClassTemplateLoader(MailConfig.class, "/mail/templates"));
		return cfg;
	}
}
