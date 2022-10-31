package com.ssafy.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@GetMapping("/test1")
	public String hello(Model model) {
		model.addAttribute("msg","안녕하세요 스프링 부트 테스트 입니다");
		return "hello";   // /WEB-INF/views/hello.jsp
	}
	
	@GetMapping("/test2")
	@ResponseBody
	public String hello() {
		return "Spring Boot Rest Call!!";   
	}
}
