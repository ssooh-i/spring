package com.ssafy.emp.model.service;

import java.util.HashMap;
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
	public boolean insertEmp(Emp emp) throws Exception{
		return sqlSession.getMapper(EmpDao.class).insertEmp(emp);
	}
	public List<Emp> listEmp() throws Exception{
		return sqlSession.getMapper(EmpDao.class).listEmp();
	}
	public boolean updateEmp(Emp emp) throws Exception{
		return sqlSession.getMapper(EmpDao.class).updateEmp(emp);
	}
	public void deleteEmp(int eno) throws Exception{
		sqlSession.getMapper(EmpDao.class).deleteEmp(eno);
	}
	public List<Emp> getEmpByEnoAndDept(Map<String, String> map) throws Exception{
		return sqlSession.getMapper(EmpDao.class).getEmpByEnoAndDept(map);
	}
	public Emp searchNo(int eno) throws Exception{
		return sqlSession.getMapper(EmpDao.class).searchNo(eno);
	}
	
	
/*	public boolean insertEmp(Emp emp) {
		int n=empDao.insertEmp(emp);
		return (n>0)?true:false;
	}

	public List<Emp> listEmp() {
		return empDao.listEmp();
	}

	public boolean update(Emp emp) {
		int n=empDao.update(emp);
		return (n>0)?true:false;
	}

	public void deleteEmp(int eno) {
		empDao.deleteEmp(eno);
	}

	public List<Emp> getEmpByEnoAndDept() {
		// Map객체에 각각 필드의 key와 value를 저장
		Map<String,Object> map=new HashMap<>();
		map.put("eno", 10);
		map.put("dept", "%"+"업"+"%");   // %업%
		List<Emp> list=empDao.getEmpByEnoAndDept(map);
		return list;
	}

	public Emp searchNo(int eno) {
		return empDao.searchNo(eno);
	}
	*/
}











