package com.edu.customer;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.customer.model.Customer;
import com.edu.customer.model.service.CustomerService;

@RestController
@RequestMapping("/user")
public class CustomerController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService service;
	
	//추가하기-------------------------------------------------------------
	//@RequestMapping(value = "/customer", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	@PostMapping(value = "/customer")
	public ResponseEntity<?> customerInsert(@RequestBody Customer vo) throws Exception {
		try {
			return new ResponseEntity<Integer>(service.customerInsert(vo), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("서버오류", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//전체보기-------------------------------------------------------------
	//@RequestMapping(value = "/customer", method = RequestMethod.GET, headers = { "Content-type=application/json" })
	@GetMapping(value = "/customer")
	public ResponseEntity<?> list() throws Exception{
		try {
			return new ResponseEntity<List<Customer>>(service.customerList(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("서버오류", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//검색하기-------------------------------------------------------------
	//@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, headers = { "Content-type=application/json" })
	@GetMapping(value = "/customer/{id}") 
	public ResponseEntity<?> searchCustomer(@PathVariable("id") String uid) throws Exception {
		try {
			return new ResponseEntity<Customer>(service.customerSearch(uid), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("서버오류", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} 
	
	//수정하기-------------------------------------------------------------
	//@RequestMapping(value = "/customer", method = RequestMethod.PUT, headers = { "Content-type=application/json" })
	@PutMapping("/customer")
	public ResponseEntity<?> customerUpdate(@RequestBody Customer vo) throws Exception {
	      try {
	         service.customerUpdate(vo);
	         return new ResponseEntity<List<Customer>>(service.customerList(),HttpStatus.OK);
	      }catch(Exception e) {
	         return new ResponseEntity<String>("서버 오류",HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	
	//삭제하기-------------------------------------------------------------
	//@RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE, headers = { "Content-type=application/json" })
	@DeleteMapping(value = "/customer/{id}")
	public ResponseEntity<?> customerDelete(@PathVariable("id") String uid) throws Exception {
		try {
			service.customerDelete(uid);
			return new ResponseEntity<List<Customer>>(service.customerList(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("서버 오류", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}










