package com.edu.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.customer.model.Customer;
import com.edu.customer.model.service.CustomerService;

@Controller
public class MainController {
	@Autowired
	private CustomerService service;
	
	// 첫 화면
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	//전체 보기
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Customer> list = service.listCustomer();
		model.addAttribute("list", list);
		return "list";
	}
	
	//고객 등록 화면 이동
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String mvInsert() {
		return "insert";
	}
	
	@RequestMapping(value = "/idcheck", method = RequestMethod.GET)
	public String idCheck(@RequestParam String id, Model model) {
		Customer customer = service.searchCustomer(id);
		model.addAttribute("id", customer);
		return "msg";
	}
	
	//고객 등록
	@RequestMapping(value = "/insertCustomer", method = RequestMethod.POST)
	public String insert(@ModelAttribute Customer customer) {
		if(service.insertCustomer(customer)) {
			return "result";
		} else {
			return "index";
		}
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String mvSearch() {
		return "search";
	}
	
	@RequestMapping(value = "/searchCustomer", method = RequestMethod.POST)
	public String search(@RequestParam String id, Model model) {
		Customer customer = service.searchCustomer(id);

		model.addAttribute("user", customer);
		return "view";
	}
}
