package com.ssafy.admin.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;

@RestController
@RequestMapping("/admin")
public class AdminUserController {
	private MemberService memberService;
	
	public AdminUserController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}
	
	@GetMapping("/user")
	public String list() throws Exception { //responseBody로 인식함 restController를 씀으로 써
		try {
			List<MemberDto> list = memberService.listMember(null);//JSON Array
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
