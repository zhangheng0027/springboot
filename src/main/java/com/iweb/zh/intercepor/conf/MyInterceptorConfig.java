package com.iweb.zh.intercepor.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.iweb.zh.intercepor.MyInterceptor;

@Configuration
public class MyInterceptorConfig implements WebMvcConfigurer {
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
		
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
    }

}
