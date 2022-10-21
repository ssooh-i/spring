package com.ssafy.emp.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssafy.emp.model.Emp;
import com.ssafy.emp.model.dao.EmpDao;

//서비스는 DAO에게 값을 보내줘야함, 페이지처리나 값을 처리하기도 하지만 여기서는 바로 값을 전달
@Service
public class EmpService {
	
	@Autowired
	private EmpDao empDao;
	
	public boolean insertEmp(Emp emp) {
		return empDao.insertEmp(emp);
	}
	
	public List<Emp> listEmp() {
		return empDao.listEmp();
	}
	
	public List<Emp> getEmpByEnoAndDept(Map<String, String> map) {
		return empDao.getEmpByEnoAndDept(map);
	}
	
	public Emp searchNo(int eno) {
		return empDao.searchNo(eno);
	}
	
	public boolean updateEmp(Emp emp) {
		int n= empDao.updateEmp(emp);
		return (n>0)?true:false;
	}
	
	public int deleteEmp(int eno) {
		return empDao.deleteEmp(eno);
	}

	public Emp selectOne(int eno) {
		
		return empDao.selectOne(eno);
	}
	
}
