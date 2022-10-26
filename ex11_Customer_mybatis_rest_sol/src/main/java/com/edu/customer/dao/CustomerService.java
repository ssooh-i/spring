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
	public int customerInsert(CustomerVO  vo) throws Exception {
		return sqlSession.getMapper(CustomerDao.class).customerInsert(vo);
		
//		CustomerVO customer = customerSearch(vo.getId());
//		if(customer!=null) {
//			return false;
//		}else {
//			int n=sqlSession.getMapper(CustomerDao.class).customerInsert(vo);
//			return (n>0)?true:false;
//		}
	}

	public List<CustomerVO> customerList() throws Exception {
		List<CustomerVO> list=sqlSession.getMapper(CustomerDao.class).customerList();
		return list;
	}

	public CustomerVO customerSearch(String uid) throws Exception{
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
	public void customerUpdate(CustomerVO vo) throws Exception{
		sqlSession.getMapper(CustomerDao.class).customerUpdate(vo);
	}
}
