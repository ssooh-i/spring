package com.ssafy.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	// insert.jsp로 포워드
	@GetMapping("/insert")
	public String insert() {
		return "board/insert";
	}
	
	// list.jsp로 포워드
	@GetMapping("/list")
	public String list() {
		return "board/list";
	}
	
	// read.jsp로 포워드
	@GetMapping("/list/{boardId}")
	public String read() {
		return "board/read";
	}
	
	// update.jsp로 포워드
	@GetMapping("/list/{boardId}/update-form")
	public String updateForm() {
		return "board/update";
	}
}
