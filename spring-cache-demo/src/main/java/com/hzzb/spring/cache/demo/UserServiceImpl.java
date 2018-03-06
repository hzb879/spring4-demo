package com.hzzb.spring.cache.demo;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public User save(User user) {
		user.setId(1);
		return user;
	}

	@Override
	public User get(Integer id) {
		System.out.println("get方法执行了..." + id);
		return new User(id, "小明" + id, 3333);
	}

}
