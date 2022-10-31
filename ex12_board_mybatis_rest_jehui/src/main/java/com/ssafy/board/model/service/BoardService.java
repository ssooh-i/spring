package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao dao;
	
	public int insertBoard(Board board) {
		return dao.insertBoard(board);
	}

	public List<Board> listBoard() {
		return dao.listBoard();
	}

	public Board selectOne(int num) {
		return dao.selectOne(num);
	}
	
	public int updateBoardHit(int num) {
		return dao.updateBoardHit(num);
	}
	
	public int deleteBoard(int num) {
		return dao.deleteBoard(num);
	}

	public int updateBoard(Board board) {
		return dao.updateBoard(board);
	}
}
