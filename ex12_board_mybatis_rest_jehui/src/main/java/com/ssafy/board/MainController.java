package com.ssafy.board;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@GetMapping({"/", "/index"})
	public String home(Locale locale, Model model) {
		return "index";
	}
	@GetMapping("/insert")
	public String insert(Locale locale, Model model) {
		return "/board/insert";
	}
	@GetMapping("/list")
	public String list(Locale locale, Model model) {
		return "board/list";
	}
	@GetMapping("/read")
	public String read(Locale locale, Model model) {
		return "board/read";
	}
	@GetMapping("/update")
	public String update(Locale locale, Model model) {
		return "board/update";
	}
	
	@GetMapping(value="/list/{num}")
	public String listOne(Locale locale, Model model, @PathVariable("num")int num) throws Exception {
		return "board/read";
	}

	@GetMapping(value="/list/{num}/update-form")
	public String update(Locale locale, Model model, @PathVariable("num")int num) throws Exception {
		return "board/update";
	}
}
