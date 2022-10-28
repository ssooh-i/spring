package com.ssafy.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.Board;
import com.ssafy.board.model.service.BoardService;

@RestController
@RequestMapping("/bbs")
public class BoardRestController {
	BoardService service;
	
	@Autowired
	public BoardRestController(BoardService service) {
		this.service = service;
	}
	
	// 게시글 리스트 가져오기
	@GetMapping("/articles")
	public ResponseEntity<?> getArticles() throws Exception {
		return new ResponseEntity<List<Board>>(service.list(), HttpStatus.OK);
	}

	// 게시글 쓰기
	@PostMapping("/articles")
	public ResponseEntity<?> insert(@RequestBody Board board) throws Exception {
		board.setHit(0);
//		board.setRegdate(new Date());
		return new ResponseEntity<Integer>(service.insert(board), HttpStatus.OK);
	}
	
	// 특정 게시글 가져오기
	@GetMapping("/articles/{boardId}")
	public ResponseEntity<?> getArticle(@PathVariable("boardId") int num) throws Exception {
		return new ResponseEntity<Board>(service.board(num), HttpStatus.OK);
	}
	
	// 특정 게시글 수정하기
	@PutMapping("/articles")
	public ResponseEntity<?> update(@RequestBody Board board) throws Exception {
		return new ResponseEntity<Integer>(service.update(board), HttpStatus.OK);
	}
	
	// 특정 게시글 삭제하기
	@DeleteMapping("/articles/{boardId}")
	public ResponseEntity<?> delete(@PathVariable("boardId") int num) throws Exception {
		return new ResponseEntity<Integer>(service.delete(num), HttpStatus.OK);
	}
}
