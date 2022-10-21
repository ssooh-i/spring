package com.ssafy.emp.model.dao;

import java.util.List;
import java.util.Map;
import com.ssafy.emp.model.Emp;

public interface EmpDao {
	public boolean insertEmp(Emp emp);
	public List<Emp> listEmp();
	public List<Emp> getEmpByEnoAndDept(Map<String, String> map);
	public Emp searchNo(int eno) ; 
	public boolean updateEmp(Emp emp);
	public void deleteEmp(int eno) ;
}












