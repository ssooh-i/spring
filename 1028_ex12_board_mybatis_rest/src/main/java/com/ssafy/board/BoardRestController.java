package com.ssafy.board;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;

@RestController
@RequestMapping("/rest")
public class BoardRestController {
	private static final Logger logger = LoggerFactory.getLogger(BoardRestController.class);
	
	@Autowired
	private BoardService boardService;
	
	//insert
	//@RequestMapping(value = "/board", method = RequestMethod.POST, headers = { "Content-type=application/json" })
//	@PostMapping("/board")
//	public ResponseEntity<?> Insert(@RequestBody BoardDto boardDto){
//		try {
//			return new ResponseEntity<Integer>(boardService.Insert(boardDto), HttpStatus.OK);
//		}catch(Exception e) {
//			return new ResponseEntity<String>("서버오류", HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	
	//전체 list
	//@RequestMapping(value = "/board", method = RequestMethod.GET, headers = { "Content-type=application/json" })
		@GetMapping(value = "/board")
		public ResponseEntity<?> List() throws Exception{
			try {
				return new ResponseEntity<List<BoardDto>>(boardService.List(), HttpStatus.OK);
			}catch(Exception e) {
				return new ResponseEntity<String>("서버오류", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	
	//search
		@GetMapping(value = "/board/{writer}") 
		public ResponseEntity<?> Search(@PathVariable("writer") String writer) throws Exception {
			
			
			try {
				return new ResponseEntity<BoardDto>(boardService.Search(writer), HttpStatus.OK);
			}catch(Exception e) {
				return new ResponseEntity<String>("서버오류", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} 
	
	//update
		@PutMapping("/board")
		public ResponseEntity<?> Update(@RequestBody BoardDto boardDto) throws Exception {
		      try {
		         boardService.Update(boardDto);
		         return new ResponseEntity<List<BoardDto>>(boardService.List(),HttpStatus.OK);
		      }catch(Exception e) {
		         return new ResponseEntity<String>("서버 오류",HttpStatus.INTERNAL_SERVER_ERROR);
		      }
		}
		
	//delete
		@DeleteMapping(value = "/board/{id}")
		public ResponseEntity<?> Delete(@PathVariable("writer") String writer) throws Exception {
			try {
				boardService.Delete(writer);
				return new ResponseEntity<List<BoardDto>>(boardService.List(), HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<String>("서버 오류", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
}
