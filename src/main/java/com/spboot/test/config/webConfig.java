package com.spboot.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.spboot.test.interceptor.AuthInterceptor;

@Configuration
public class webConfig implements WebMvcConfigurer {

	@Autowired
	private AuthInterceptor authInterceptor;

	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authInterceptor)
		.excludePathPatterns("/resources/**")
		.excludePathPatterns("/views/user/login")	
		.addPathPatterns("/**");
	}

}
