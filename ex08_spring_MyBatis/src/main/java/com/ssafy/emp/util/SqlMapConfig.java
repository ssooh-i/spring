package com.ssafy.emp.util;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {
	private static SqlSessionFactory factory;
	
	static {
		try {
			String resource="myBatis-config.xml";
			Reader reader=Resources.getResourceAsReader(resource);
			factory=new SqlSessionFactoryBuilder().build(reader);
                                                 // default에 연결(environment="dev")
			//factory=new SqlSessionFactoryBuilder().build(reader,"eng");
                                                         // environment="eng"가 있다면
		}catch(IOException e) {}
	}
	
	public static SqlSession getSqlSession() {
		return factory.openSession(true);
	}
}








