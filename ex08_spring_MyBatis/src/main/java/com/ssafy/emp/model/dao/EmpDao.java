package com.ssafy.emp.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.ssafy.emp.model.Emp;
import com.ssafy.emp.util.SqlMapConfig;

//DAO는 레파지토리
@Repository
public class EmpDao {
	
	//마이바티스 쓰기위해서 SqlMapConfig을 완성 해야함
	//insert
	public boolean insertEmp(Emp emp) {
		SqlSession session=SqlMapConfig.getSqlSession();//싱글톤으로 만든 세션들고오기
		//namespace명: my.empMapper / id명: insertEmp
		int n = session.insert("my.empMapper.insertEmp", emp);
		return (n>0)?true:false; //값이 0보다 크면 true
	}
	
	//list
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
	
	public int updateEmp(Emp emp) {
		SqlSession session=SqlMapConfig.getSqlSession();
		int n=session.update("my.empMapper.updateEmp", emp);
		return n;
	}
	
	public int deleteEmp(int eno) {
		SqlSession session=SqlMapConfig.getSqlSession();
		return session.delete("my.empMapper.deleteEmp", eno);
	}

	public Emp selectOne(int eno) {
		SqlSession session=SqlMapConfig.getSqlSession();
		return session.selectOne("my.empMapper.selectOneEmp", eno);
	}
}

/*
selectList(): 여러건의 데이터
selectOne() : 1건의 데이터
*/