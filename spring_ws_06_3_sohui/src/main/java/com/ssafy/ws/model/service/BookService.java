package com.ssafy.ws.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssafy.ws.dto.Book;
import com.ssafy.ws.model.repo.BookRepo;
import com.ssafy.ws.model.repo.UserRepo;

@Service
public class BookService {
	@Autowired
	private BookRepo bookRepo;
	
	public List<Book> getList(){
		return bookRepo.getList();
	}

	public boolean registBook(Book book) { // insert
		
		if(bookRepo.insBook(book)>0) {
			return true;
		}
		
		return false;
	}
}
