package com.edu.customer.dao;

import java.util.List;

import com.edu.customer.vo.CustomerVO;

public interface CustomerDao {
	public int customerInsert(CustomerVO  vo) throws Exception;
	List<CustomerVO> customerList() throws Exception;
	public CustomerVO customerSearch(String uid) throws Exception;
	int idCheck(String checkId) throws Exception;
}
