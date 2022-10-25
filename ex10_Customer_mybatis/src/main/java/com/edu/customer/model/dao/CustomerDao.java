package com.edu.customer.model.dao;

import java.util.List;

import com.edu.customer.model.Customer;

public interface CustomerDao {

	List<Customer> listCustomer();
	boolean insertCustomer(Customer customer);
	Customer searchCustomer(String id);

}
