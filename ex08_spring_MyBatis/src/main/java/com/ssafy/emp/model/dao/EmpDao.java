package com.ssafy.emp.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.ssafy.emp.model.Emp;
import com.ssafy.emp.util.SqlMapConfig;

@Repository
public class EmpDao {

	//namespace명: my.empMapper / id명: insertEmp
	public boolean insertEmp(Emp emp) {
		SqlSession session=SqlMapConfig.getSqlSession();
		int n=session.insert("my.empMapper.insertEmp", emp);
		return (n>0)?true:false;
	}

	public List<Emp> listEmp() {
		SqlSession session=SqlMapConfig.getSqlSession();
		return session.selectList("my.empMapper.listEmp");
	}

	public List<Emp> getEmpByEnoAndDept(Map<String, String> map) {
		SqlSession session=SqlMapConfig.getSqlSession();
		return session.selectList("my.empMapper.getEmpByEnoAndDept", map);
	}

	public Emp searchNo(int eno) {
		SqlSession session=SqlMapConfig.getSqlSession();
		return session.selectOne("my.empMapper.searchNo", eno);
	}
	
	public boolean updateEmp(Emp emp) {
		SqlSession session=SqlMapConfig.getSqlSession();
		int n=session.update("my.empMapper.updateEmp", emp);
		return (n>0)?true:false;
	}
	
	public void deleteEmp(int eno) {
		SqlSession session=SqlMapConfig.getSqlSession();
		session.delete("my.empMapper.deleteEmp", eno);
	}
}
/*
selectList(): 여러건의 데이터
selectOne() : 1건의 데이터
*/












