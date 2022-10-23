package com.edu.customer;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.customer.dao.CustomerDao;
import com.edu.customer.dao.CustomerService;
import com.edu.customer.vo.CustomerVO;

@Controller
public class CustomerController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
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
	
	@PostMapping(value = "/customerInsert")
	public String customerInsert(CustomerVO vo, Model model) throws Exception {
		boolean result=service.customerInsert(vo);
		model.addAttribute("username", vo.getName());
		model.addAttribute("result", result);
		return "customer/result";
	}
	
	@GetMapping(value = "/search")
	public String search() {
		return "customer/search";
	}
	
	@PostMapping(value = "/searchCustomer") 
	public String searchCustomer(@RequestParam("id") String uid, Model model) throws Exception {
		//System.out.println(uid);
		CustomerVO customer=service.customerSearch(uid);
		model.addAttribute("customer", customer);
		return "customer/view";
	}
	
	@GetMapping(value = "/list")
	public String list(Model model) throws Exception{
		List<CustomerVO> list=service.customerList();
		model.addAttribute("list", list);
		return "customer/list";
	}
	
	@GetMapping(value = "/idCheck")
	@ResponseBody
	public String idCheck(@RequestParam("ckid") String checkid) throws Exception{
		int idCount=service.idCheck(checkid);
		JSONObject json = new JSONObject();
		json.put("idcount", idCount);   // {idCount:1}
		return json.toString();
	}
}










