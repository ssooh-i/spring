package com.ssafy.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ssafy.board.model.Board;

public interface BoardDao {
	public int insert(Board board)throws Exception;
	public List<Board> list()throws Exception;
	public boolean updateHit(int num)throws Exception;
	public Board board(int num)throws Exception;
	public int update(Board board)throws Exception;
	public int delete(int num)throws Exception;
}
//-------------------------------------------------
/*
@Repository
public class BoardDao {

	@Autowired
	private SqlSessionFactory factory;

	public boolean insert(Board board) {
		int n = factory.openSession().insert("mybatis.board.insertboard", board);
		return (n > 0) ? true : false;
	}

	public List<Board> list() {
		return factory.openSession().selectList("mybatis.board.selectboardList");
	}

	public boolean updateHit(int num) {
		int n = factory.openSession().update("mybatis.board.updateHit", num);
		return (n > 0) ? true : false;
	}

	public Board board(int num) {
		return factory.openSession().selectOne("mybatis.board.selectboard", num);
	}

	public boolean update(Board board) {
		int n = factory.openSession().update("mybatis.board.update", board);
		return (n > 0) ? true : false;
	}

	public boolean delete(int num) {
		int n = factory.openSession().update("mybatis.board.delete", num);
		return (n > 0) ? true : false;
	}
}
*/
