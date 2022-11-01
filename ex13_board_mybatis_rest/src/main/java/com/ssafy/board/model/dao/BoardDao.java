package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Board;

public interface BoardDao {

	int insertBoard(Board board);
	List<Board> listBoard();
	Board selectOne(int num);
	int updateBoardHit(int num);
	int deleteBoard(int num);
	int updateBoard(Board board);
}
