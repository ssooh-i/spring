package com.edu.customer.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.customer.model.Customer;
import com.edu.customer.model.dao.CustomerDao;

@Service
public class CustomerService{
	@Autowired
	private SqlSession sqlSession;
	
	@Transactional
	public int customerInsert(Customer  vo) throws Exception {
		return sqlSession.getMapper(CustomerDao.class).customerInsert(vo);
		
//		CustomerVO customer = customerSearch(vo.getId());
//		if(customer!=null) {
//			return false;
//		}else {
//			int n=sqlSession.getMapper(CustomerDao.class).customerInsert(vo);
//			return (n>0)?true:false;
//		}
	}

	public List<Customer> customerList() throws Exception {
		List<Customer> list=sqlSession.getMapper(CustomerDao.class).customerList();
		return list;
	}

	public Customer customerSearch(String uid) throws Exception{
		return sqlSession.getMapper(CustomerDao.class).customerSearch(uid);
	}

	public int idCheck(String checkid) throws Exception{
		return sqlSession.getMapper(CustomerDao.class).idCheck(checkid);
	}
	
	@Transactional
	public void customerDelete(String uid) throws Exception{
		sqlSession.getMapper(CustomerDao.class).customerDelete(uid);
	}
	
	@Transactional
	public void customerUpdate(Customer vo) throws Exception{
		sqlSession.getMapper(CustomerDao.class).customerUpdate(vo);
	}
}
