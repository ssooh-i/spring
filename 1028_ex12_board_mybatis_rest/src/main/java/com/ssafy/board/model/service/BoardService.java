package com.ssafy.board.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.dao.BoardDao;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Transactional
	public int Insert(BoardDto boardDto) throws SQLException{
		return boardDao.insert(boardDto);
	}
	
	public List<BoardDto> List() throws Exception{
		List<BoardDto> list = boardDao.list();
		return list;
	}
	
	public BoardDto Search(String writer) throws Exception{
		return boardDao.search(writer);
	}
	
	@Transactional
	public void Update(BoardDto boardDto) throws Exception{
		boardDao.update(boardDto);
	}
	
	@Transactional
	public void Delete(String writer) throws Exception{
		boardDao.delete(writer);
	}
}
