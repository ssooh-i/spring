package com.ssafy.ws.model.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssafy.ws.dto.User;
import com.ssafy.ws.model.repo.UserRepo;

@Service
public class UserService {
	@Autowired
	private SqlSession sqlSession;
	
	public User getLoginUser(User user) {
		return sqlSession.getMapper(UserRepo.class).getLoginUser(user);
	}

}
