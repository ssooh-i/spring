package com.ssafy.emp.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.emp.model.Emp;
import com.ssafy.emp.model.dao.EmpDao;

@Service
public class EmpService {
	@Autowired
	private SqlSession sqlSession;

	@Transactional
	public boolean insertEmp(Emp emp) {
		return sqlSession.getMapper(EmpDao.class).insertEmp(emp);
	}
	public List<Emp> listEmp() throws Exception{
		return sqlSession.getMapper(EmpDao.class).listEmp();
	}
	
	public List<Emp> getEmpByEnoAndDept(Map<String, String> map) throws Exception{
		return sqlSession.getMapper(EmpDao.class).getEmpByEnoAndDept(map);
	}
	
	public Emp searchNo(int eno) throws Exception{
		return sqlSession.getMapper(EmpDao.class).searchNo(eno);
	}
	
	@Transactional
	public boolean updateEmp(Emp emp) throws Exception {
		return sqlSession.getMapper(EmpDao.class).updateEmp(emp);
	}
	
	@Transactional
	public void deleteEmp(int eno) throws Exception {
		sqlSession.getMapper(EmpDao.class).deleteEmp(eno);
	}
}








