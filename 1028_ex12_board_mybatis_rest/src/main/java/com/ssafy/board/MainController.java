package com.ssafy.board;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/insert")
	public String insert() {
		logger.info("insert controller Run");
		return "board/insert";
	}
	
	@GetMapping("/search")
	public String search() {
		return "board/search";
	}
	
	@GetMapping("/list")
	public String list() {
		return "board/list";
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}
	
	@PostMapping("/board")
	public String Insert(@ModelAttribute BoardDto boardDto){
		try {
			int n = boardService.Insert(boardDto);
			if(n > 0) return "redirect:/list";
			else return "redirect:/";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "redirect:/";
		}
	}
	
}
