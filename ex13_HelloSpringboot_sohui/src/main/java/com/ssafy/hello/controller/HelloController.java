package com.ssafy.hello.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@GetMapping("/test1")
	public String hello(Model model) {
		model.addAttribute("msg", "안녕하세여 스프링 부트 테스트입니다.");
		return "hello";
	}
	
	@GetMapping("/test2")
	@ResponseBody
	public Map<String, String> Restful(Model model) {
		Map<String, String> res = new HashMap<>();
		res.put("msg", "Spring Boot Rest Call");
		return res;
	}

}
