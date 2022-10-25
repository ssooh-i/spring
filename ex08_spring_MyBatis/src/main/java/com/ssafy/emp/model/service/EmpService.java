package com.ssafy.emp.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssafy.emp.model.Emp;
import com.ssafy.emp.model.dao.EmpDao;

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
		return empDao.updateEmp(emp);
	}
	
	public void deleteEmp(int eno) {
		empDao.deleteEmp(eno);
	}
}








