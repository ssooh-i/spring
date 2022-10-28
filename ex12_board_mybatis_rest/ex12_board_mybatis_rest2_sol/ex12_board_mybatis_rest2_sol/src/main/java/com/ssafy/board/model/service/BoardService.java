package com.ssafy.board.model.service;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.model.Board;
import com.ssafy.board.model.dao.BoardDao;


@Service
public class BoardService {
	@Autowired
	private SqlSession sqlSession;
	
	@Transactional
	public int insert(Board board) throws Exception{
		return sqlSession.getMapper(BoardDao.class).insert(board);
	}

	public List<Board> list() throws Exception {
		return sqlSession.getMapper(BoardDao.class).list();
	}

	public Board board(int num) throws Exception {
		// 조회수를 1 늘려주고 나서
		sqlSession.getMapper(BoardDao.class).updateHit(num);
		// board 정보 가져오기
		return sqlSession.getMapper(BoardDao.class).board(num);
	}

	@Transactional
	public int update(Board board) throws Exception {
		return sqlSession.getMapper(BoardDao.class).update(board);
	}

	@Transactional
	public int delete(int num) throws Exception{
		return sqlSession.getMapper(BoardDao.class).delete(num);
	}
}
