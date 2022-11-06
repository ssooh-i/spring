package com.ssafy.ws;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.ws.interceptor.SessionInterceptor;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//프록시 설정 <aop:aspectj-autoproxy></aop:aspectj-autoproxy>를 대체한다.
@EnableAspectJAutoProxy
//mybatis의 매퍼 스캔: <mybatis:scan base-package="com.ssafy.ws.model.repo"/>를 대체한다.
@MapperScan(basePackages = "com.ssafy.ws.model.repo")
//Swagger 사용을 위해 추가한다.
@EnableSwagger2
public class SpringWs93Application implements WebMvcConfigurer {

	@Autowired
	SessionInterceptor si;

	/**
	 * interceptor를 등록한다. <inteceptors> 태그의 내용을 대체한다.
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(si).addPathPatterns("/regist");
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringWs93Application.class, args);
	}

}
