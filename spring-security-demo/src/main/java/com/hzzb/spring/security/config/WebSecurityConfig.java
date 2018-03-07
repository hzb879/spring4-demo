package com.hzzb.spring.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	/**
	 * 从数据库或其他地方查询出来的用户和其权限配置,用于认证和授权
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("aaa").password("bbb").authorities("OP_USER_DELETE","ROLE_ADMIN").build());
		manager.createUser(User.withUsername("ccc").password("ddd").authorities("OP_USER_add","ROLE_USER").build());
		auth.userDetailsService(manager);
	}
	
	/**
	 * 静态资源配置
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/assets/**");
	}
	
	/**
	 * 资源配置
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests().antMatchers("/**").authenticated();
//		.and()
//        .formLogin().usernameParameter("username").passwordParameter("password")
//        .permitAll() //登录页面用户任意访问  
//        .defaultSuccessUrl("/index")
//        .and()  
//        .logout().permitAll(); //注销行为任意访问 
	}
}
