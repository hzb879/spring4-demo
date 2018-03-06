package com.hzzb.spring.cache.demo;

import java.net.URISyntaxException;

import javax.cache.Caching;
import javax.cache.spi.CachingProvider;

import org.springframework.cache.CacheManager;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {
	
	/**
	 * 测试用
	 */
//	@Bean
//	CacheManager cacheManager() {
//		ConcurrentMapCacheManager concurrentMapCacheManager = new ConcurrentMapCacheManager();
//		return concurrentMapCacheManager;
//	}
	
	
//	/**
//	 * ehcache 转jcache 的Java配置(方式1)
//	 * @return
//	 */
//	@Bean
//	CacheManager cacheManager() {
//		
//		Map<String, CacheConfiguration<?, ?>> caches = new HashMap<>();
//		CacheConfiguration<Object, Object> cacheConfiguration = CacheConfigurationBuilder
//			.newCacheConfigurationBuilder(Object.class, Object.class, 
//			ResourcePoolsBuilder.heap(2000))
//			.withExpiry(
//					Expirations.timeToLiveExpiration(
//							Duration.of(2, TimeUnit.SECONDS))).build();
//		caches.put("userCache", cacheConfiguration);
//		
//		CachingProvider cachingProvider = Caching.getCachingProvider();
//		EhcacheCachingProvider ehcacheProvider = (EhcacheCachingProvider) cachingProvider; 
//
//		javax.cache.CacheManager cacheManager = ehcacheProvider
//				.getCacheManager(ehcacheProvider.getDefaultURI(),
//						new DefaultConfiguration(caches, cachingProvider.getDefaultClassLoader()));
//		
//		return new JCacheCacheManager(cacheManager);
//	}
	
//	/**
//	 * ehcache 转jcache 的Java配置(方式2)
//	 * @return
//	 */
//	@Bean
//	CacheManager cacheManager() {
//		
//		CacheConfiguration<Object, Object> ehcacheConfig = CacheConfigurationBuilder
//			.newCacheConfigurationBuilder(Object.class, Object.class, 
//			ResourcePoolsBuilder.heap(2000))
//			.withExpiry(
//					Expirations.timeToLiveExpiration(
//							Duration.of(2, TimeUnit.SECONDS))).build();
//		
//		CachingProvider cachingProvider = Caching.getCachingProvider();
//		javax.cache.CacheManager cacheManager = cachingProvider.getCacheManager();
//		
//		cacheManager.createCache("userCache", 
//				Eh107Configuration.fromEhcacheCacheConfiguration(ehcacheConfig));
//		
//		return new JCacheCacheManager(cacheManager);
//	}

	/**
	 * ehcache 转jcache 的xml配置
	 * @return
	 * @throws URISyntaxException 
	 */
	@Bean
	CacheManager cacheManager() throws URISyntaxException {
		CachingProvider cachingProvider = Caching.getCachingProvider();
		javax.cache.CacheManager manager = cachingProvider.getCacheManager( 
		    getClass().getResource("/ehcache.xml").toURI(), 
		    getClass().getClassLoader()); 
		return new JCacheCacheManager(manager);
	}
	
	
}
