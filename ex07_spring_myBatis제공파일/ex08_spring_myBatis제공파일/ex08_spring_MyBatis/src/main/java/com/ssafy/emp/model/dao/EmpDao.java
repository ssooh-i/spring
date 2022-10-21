package com.ssafy.emp.model.dao;

import java.util.List;
import java.util.Map;
import com.ssafy.emp.model.Emp;

public interface EmpDao {
	public boolean insertEmp(Emp emp) throws Exception;
	public List<Emp> listEmp() throws Exception;
	public boolean updateEmp(Emp emp) throws Exception;
	public void deleteEmp(int eno) throws Exception;
	public List<Emp> getEmpByEnoAndDept(Map<String, String> map) throws Exception;
	public Emp searchNo(int eno) throws Exception;
}
