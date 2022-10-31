package com.ssafy.hw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.hw.model.dto.SearchCondition;
import com.ssafy.hw.model.dto.User;
import com.ssafy.hw.model.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/userapi")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class UserRestController {

	@Autowired
	UserService us;

	@GetMapping("/user")
	@ApiOperation(value = "등록된 모든 사용자 정보를 반환한다.", response = User.class)
	public ResponseEntity<?> selectAll() {
		// try {
		// 	List<User> users = us.selectAll();
		// 	if (_________) {
		// 		return _________;
		// 	} else {
		// 		return _________;
		// 	}
		// } catch (Exception e) {
		// 	return exceptionHandling(e);
		// }
		return null; //에러방지
	}

	@GetMapping("/user/{id}")
	@ApiOperation(value = "{id}에 해당하는 사용자 정보를 반환한다.", response = User.class)
	public ResponseEntity<?> select(@PathVariable String id) {
		// try {
		// 	User user = us.searchById(id);
		// 	if (_________) {
		// 		return _________;
		// 	} else {
		// 		return _________);
		// 	}
		// } catch (Exception e) {
		// 	return exceptionHandling(e);
		// }
		return null; //에러방지
	}

	@GetMapping("/user/search")
	@ApiOperation(value = "SearchCondition 에 부합하는 조건을 가진 사용자 목록을 반환한다.", response = User.class)
	public ResponseEntity<?> search(SearchCondition con) {
		// try {
		// 	List<User> users = us.searchByCondition(con);
		// 	if (_________) {
		// 		return _________;
		// 	} else {
		// 		return _________;
		// 	}
		// } catch (Exception e) {
		// 	return exceptionHandling(e);
		// }
		return null;
	}

	@PostMapping("/user")
	@ApiOperation(value = "사용자 정보를 삽입한다.", response = Integer.class)
	public ResponseEntity<?> insert(User user) {
//		// try {
//		// 	int result = us.insert(user);
//		// 	return _________;
//
//		// } catch (Exception e) {
//		// 	return exceptionHandling(e);
//		// }

		return null;
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
