package com.ssafy.board.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.board.model.BoardDto;

@Mapper
public interface BoardDao {
	int insert(BoardDto boardDto) throws SQLException; //게시글 삽입
	List<BoardDto> list() throws Exception; //전체 리스트보기
	
	public BoardDto search(String writer) throws Exception; //게시글 검색
	void update(BoardDto boardDto) throws Exception; //게시글 수정
	void delete(String writer) throws Exception; //게시글 삭제
}

