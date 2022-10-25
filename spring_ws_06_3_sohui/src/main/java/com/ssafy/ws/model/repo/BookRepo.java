package com.ssafy.ws.model.repo;

import java.util.List;
import com.ssafy.ws.dto.Book;

public interface BookRepo {
	public List<Book> getList();
	public int insBook(Book book);
}
