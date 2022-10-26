package com.edu.customer;

import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.customer.dao.CustomerService;
import com.edu.customer.vo.CustomerVO;

@Controller
@RequestMapping("/")
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private CustomerService service;
	
	@GetMapping(value = "/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value = "/insert")
	public String insert() {
		return "customer/insert";
	}
	
	@GetMapping(value = "/search")
	public String search() {
		return "customer/search";
	}
	
	@GetMapping(value = "/list")
	public String list(){
		return "customer/list";
	}
	
	@GetMapping(value = "/idCheck")
	@ResponseBody //원래있던(호출했던) 그자리로 가기
	public String idCheck(@RequestParam("ckid") String checkid) throws Exception{
		//해당하는 위치 비동기처리하려고 페이지가 없음
		int idCount=service.idCheck(checkid);
		JSONObject json = new JSONObject();
		json.put("idcount", idCount);   // {idCount:1}
		return json.toString();
	}
}
