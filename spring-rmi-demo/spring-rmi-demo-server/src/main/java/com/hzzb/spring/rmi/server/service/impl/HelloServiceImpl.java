package com.hzzb.spring.rmi.server.service.impl;

import org.springframework.stereotype.Service;

import com.hzzb.spring.rmi.server.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService{

	@Override
	public String hello(String msg) {
		return "rmi服务端的接收到[" + msg + "]";
	}

}
