package com.hzzb.spring.oxm.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.hzzb.spring.oxm.demo.bean.Person;
import com.hzzb.spring.oxm.demo.helper.XmlHelper;

@Configuration
@ComponentScan
public class Application {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext atx = new AnnotationConfigApplicationContext(Application.class);
		XmlHelper xmlHelper = atx.getBean(XmlHelper.class);
		String xml = xmlHelper.objToXml(new Person("健身房", 345, true));
		Person p = xmlHelper.xmlToObj(xml);
		System.out.println(xml);
		System.out.println(p);
		Person p2 = xmlHelper.xmlToObj("<person><age>234</age><name>健身房234</name><super_user>false</super_user></person>");
		System.out.println(p2);
	}
}
