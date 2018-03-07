package com.hzzb.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.hzzb.web"
//	excludeFilters = @Filter(
//		type = FilterType.ANNOTATION, 
//		value = EnableWebMvc.class)
)
public class RootConfig {

}
