package com.hzzb.aop.service;

import org.springframework.stereotype.Service;

@Service
public class PerformanceImpl implements Performance{

	@Override
	public String perform() {
		System.out.println("表演进行");
		return "谢谢观看";
	}

	@Override
	public String dance(String type) {
		System.out.println("跳舞进行..." + type);
		return "跳舞很开心";
	}

}
