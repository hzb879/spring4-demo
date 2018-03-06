package com.hzzb.spring.cache.demo;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames = "userCache")
public interface UserService {
	
	@CachePut(key = "#result.id")
	User save (User user);
	
	@Cacheable
	User get(Integer id);
	
}
