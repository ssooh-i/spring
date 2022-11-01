package com.ssafy.board;

import java.time.LocalDate;
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

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.service.BoardService;

@RestController
@RequestMapping("/bc")
public class BoardRestController {
	
	@Autowired
	BoardService service;
	
	@PostMapping(value="/insert")
	public ResponseEntity<?> insert(@RequestBody Board board) throws Exception {
	      try {
	    	  board.setRegdate(LocalDate.now().toString());
	    	  board.setHit(0);
	         return new ResponseEntity<Integer>(service.insertBoard(board), HttpStatus.OK);
	      }catch(Exception e) {
	    	  e.printStackTrace();
	         return new ResponseEntity<String>("서버 오류",HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	
	@GetMapping(value="list")
	public ResponseEntity<?> list() throws Exception {
	      try {
	         return new ResponseEntity<List<Board>>(service.listBoard(), HttpStatus.OK);
	      }catch(Exception e) {
	    	  e.printStackTrace();
	         return new ResponseEntity<String>("서버 오류",HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	
	@PostMapping(value="list/{num}")
	public ResponseEntity<?> listOne(@PathVariable("num")Integer num) throws Exception {
		try {
			service.updateBoardHit(num);
			return new ResponseEntity<Board>(service.selectOne(num), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("서버 오류",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="list/{num}")
	public ResponseEntity<?> delete(@PathVariable("num")Integer num) throws Exception {
		try {
			return new ResponseEntity<Integer>(service.deleteBoard(num), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("서버 오류",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="pwdCheck")
	public ResponseEntity<?> passwordCheck(@RequestBody Board board) throws Exception {
		try {
			Board foundBoard = service.selectOne(board.getNum());
			if(foundBoard.getPwd().equals(board.getPwd()))
				return new ResponseEntity<Integer>(1, HttpStatus.OK);
			else
				return new ResponseEntity<Integer>(0, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("서버 오류",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value="update")
	public ResponseEntity<?> update(@RequestBody Board board) throws Exception {
		try {
			return new ResponseEntity<Integer>(service.updateBoard(board), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("서버 오류",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
