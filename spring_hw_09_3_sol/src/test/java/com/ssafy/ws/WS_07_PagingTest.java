package com.ssafy.ws;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.dto.SearchCondition;
import com.ssafy.ws.model.service.BookService;
import com.ssafy.ws.util.PageNavigation;

public class WS_07_PagingTest extends AbstractTest {

	private static final Logger logger = LoggerFactory.getLogger(WS_07_PagingTest.class);

	@Autowired
	BookService bs;

	@Test
	public void testPagingSearch() {
		SearchCondition condition = new SearchCondition("author", "무국", "isbn", "asc", 1);
		Map<String, Object> searchResult = bs.pagingSearch(condition);
		System.out.println(searchResult);
		List<Book> list = (List<Book>) searchResult.get("books");
		for (int i = 0; i < list.size(); i++) {
			logger.debug("{} -{}", i, list.get(i));
		}
		PageNavigation nav = (PageNavigation) searchResult.get("navigation");
		assertEquals(nav.getCurrentPage(), condition.getCurrentPage());

	}

}
