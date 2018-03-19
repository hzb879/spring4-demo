package com.hzzb.spring.mail.demo;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

@Configuration
@ComponentScan
public class Application {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws MessagingException, TemplateNotFoundException, BeansException, MalformedTemplateNameException, ParseException, TemplateException, IOException {
		AnnotationConfigApplicationContext atx = 
				new AnnotationConfigApplicationContext(Application.class);
		JavaMailSenderImpl mailSender = atx.getBean(JavaMailSenderImpl.class);
//		mailSender.send(simpleMessage());
//		sendAttachMessage(mailSender);
//		sendInLineImageMessage(mailSender);
		sendHtmlMessage(mailSender, 
				atx.getBean(freemarker.template.Configuration.class), "my_mail");
	}
	
	public static SimpleMailMessage simpleMessage() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("hzb879@163.com");
		simpleMailMessage.setTo("318577055@qq.com");
		simpleMailMessage.setSubject("spring_mail测试发送邮件");
		simpleMailMessage.setText("你好");
		return simpleMailMessage;
	}
	
	public static void sendAttachMessage(JavaMailSender mailSender) throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("hzb879@163.com");
		helper.setTo("318577055@qq.com");
		helper.setSubject("spring_mail测试发送带有附件的邮件");
		helper.setText("hello^_^");
		helper.addAttachment("my_file.js", new File("/Users/spacewalker/Desktop/custom.js"));
		mailSender.send(mimeMessage);
	}
	
	public static void sendInLineImageMessage(JavaMailSender mailSender) throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("hzb879@163.com");
		helper.setTo("318577055@qq.com");
		helper.setSubject("spring_mail测试发送inline_image的邮件");
		helper.setText("hello^_^");
		helper.addInline("my_jpg", new ClassPathResource("mail/test.jpg"));
		mailSender.send(mimeMessage);
	}
	
	public static void sendHtmlMessage(JavaMailSender mailSender,
			freemarker.template.Configuration config,
			String templateName) throws MessagingException, TemplateNotFoundException, MalformedTemplateNameException, ParseException, TemplateException, IOException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
		helper.setFrom("hzb879@163.com");
		helper.setTo("318577055@qq.com");
		helper.setSubject("spring_mail测试发送HTML邮件");
		StringWriter out = new StringWriter();
		config.getTemplate(templateName + ".ftl").process(null, out);
		helper.setText(out.toString(), true);
		mailSender.send(mimeMessage);
	}
	
}
