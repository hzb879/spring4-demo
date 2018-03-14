package com.hzzb.spring.rabbitmq.demo.bean;

import java.io.Serializable;

public class Bread implements Serializable{
	private String name;
	private Integer count;
	private Boolean soldedOut;
	
	public Bread() {
		super();
	}
	
	public Bread(String name, Integer count, Boolean soldedOut) {
		super();
		this.name = name;
		this.count = count;
		this.soldedOut = soldedOut;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Boolean getSoldedOut() {
		return soldedOut;
	}
	public void setSoldedOut(Boolean soldedOut) {
		this.soldedOut = soldedOut;
	}
	
	@Override
	public String toString() {
		return "Bread [name=" + name + ", count=" + count + ", soldedOut=" + soldedOut + "]";
	}
	
}
