package com.edu.customer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.customer.vo.CustomerVO;

@Service
public class CustomerService{
	@Autowired
	private SqlSession sqlSession;
	
	@Transactional
	public boolean customerInsert(CustomerVO  vo) throws Exception {
//		CustomerDao dao=sqlSession.getMapper(CustomerDao.class);
//		int n=dao.customerInsert(vo);
		CustomerVO customer = customerSearch(vo.getId());
		if(customer!=null) {
			return false;
		}else {
			int n=sqlSession.getMapper(CustomerDao.class).customerInsert(vo);
			return (n>0)?true:false;
		}
	}

	public List<CustomerVO> customerList() throws Exception {
		List<CustomerVO> list=sqlSession.getMapper(CustomerDao.class).customerList();
		return list;
	}

	public CustomerVO customerSearch(String uid) throws Exception{
		CustomerVO customer=sqlSession.getMapper(CustomerDao.class).customerSearch(uid);
		return customer;
	}

	public int idCheck(String checkid) throws Exception{
		return sqlSession.getMapper(CustomerDao.class).idCheck(checkid);
	}
}
