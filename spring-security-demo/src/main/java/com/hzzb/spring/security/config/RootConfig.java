package com.hzzb.spring.security.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.hzzb.spring"
//	excludeFilters = @Filter(
//		type = FilterType.ANNOTATION, 
//		value = EnableWebMvc.class)
)
public class RootConfig {

}
