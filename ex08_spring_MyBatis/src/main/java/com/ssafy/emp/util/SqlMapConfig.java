package com.ssafy.emp.util;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {
	//싱글톤패턴으로 작성
	private static SqlSessionFactory factory;
	
	static { //static 초기화
		try {//try catch 문안에서 작성 안하면 오류남
			String resource="myBatis-config.xml"; //아까 작업한 파일을 들고 온다
			Reader reader=Resources.getResourceAsReader(resource); //import는 io로 선택
			factory=new SqlSessionFactoryBuilder().build(reader);
			                                // default에 연결(environment="dev")
			//factory=new SqlSessionFactoryBuilder().build(reader,"eng");
			                                // environment="eng"가 있다면 eng에 연결함 
		}catch(IOException e) {}
	}
	
	public static SqlSession getSqlSession() {//sql세션처리
		return factory.openSession(true);
	}
}
