package com.edu.customer.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.customer.model.Customer;
import com.edu.customer.model.dao.CustomerDao;

@Service
public class CustomerService {
	
	@Autowired
	SqlSession sqlSession;
	
	public List<Customer> listCustomer() {
		return sqlSession.getMapper(CustomerDao.class).listCustomer();
	}

	public boolean insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(CustomerDao.class).insertCustomer(customer);
	}

	public Customer searchCustomer(String id) {
		return sqlSession.getMapper(CustomerDao.class).searchCustomer(id);
	}

}
