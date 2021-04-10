package com.vitelco.turkcellpoc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class LogServiceInterceptorAppConfig extends WebMvcConfigurerAdapter {

	private final LogServiceInterceptor logServiceInterceptor;

	@Autowired
	public LogServiceInterceptorAppConfig(LogServiceInterceptor logServiceInterceptor) {
		this.logServiceInterceptor = logServiceInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(logServiceInterceptor).addPathPatterns("/**");
	}

}
