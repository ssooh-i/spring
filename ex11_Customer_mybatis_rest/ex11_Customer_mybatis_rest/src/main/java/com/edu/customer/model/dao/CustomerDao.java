package com.edu.customer.model.dao;

import java.util.List;

import com.edu.customer.model.Customer;

public interface CustomerDao {
	public int customerInsert(Customer  vo) throws Exception;
	List<Customer> customerList() throws Exception;
	public Customer customerSearch(String uid) throws Exception;
	int idCheck(String checkId) throws Exception;
	void customerDelete(String id) throws Exception;
	void customerUpdate(Customer vo) throws Exception;
}
