package com.hzzb.spring.oxm.demo.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
	
	private String name;
	
	private Integer age;
	
	private Boolean superUser;
	
	public Person() {
		super();
	}
	public Person(String name, Integer age, Boolean superUser) {
		super();
		this.name = name;
		this.age = age;
		this.superUser = superUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@XmlElement(name = "super_user")
	public Boolean getSuperUser() {
		return superUser;
	}
	public void setSuperUser(Boolean superUser) {
		this.superUser = superUser;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", superUser=" + superUser + "]";
	}
	
}
