package com.mycom.myapp.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	@Autowired
	private LoginInterceptor loginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
		.addPathPatterns("/**")
				//로그인 페이지 말곤 인터셉터로 세션 확인하도록
		//.excludePathPatterns("/login/**", "/register/**"); // static folder // jsp 사용할 경우
		.excludePathPatterns("/", "/index.html", "/login.html", "/register.html")
		.excludePathPatterns("/login/**", "/register/**", "/css/**", "/js/**", "/img/**"); // html 사용할 경우
	}
}
