package com.ssafy.ws;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.dto.SearchCondition;
import com.ssafy.ws.model.repo.BookRepo;

public class WS_06_DynamicQueryTest extends AbstractTest{
	private static final Logger logger = LoggerFactory.getLogger(WS_06_DynamicQueryTest.class);
	
	@Autowired
	BookRepo brepo;
	
	@Test
	public void testByNone() {
		// 아무런 검색 조건 없이 조회한다. limit를 사용하지 않는다.
		SearchCondition condition = new SearchCondition();
		condition.setLimit(false);
		List<Book> selected = brepo.search(condition);
		// 기본 데이터에는 20개가 존재한다.
		assertEquals(selected.size(), 20);
		
		condition.setLimit(true);
		selected = brepo.search(condition);
		// 별 제약사항이 없다면 10개가 조회된다.
		assertEquals(selected.size(), 10);
	}
	

	@Test
	public void testByAuthor() {
		// author가 일무국인 자료 모두를 조회한다.
		SearchCondition condition = new SearchCondition("author", "일무국");
		List<Book> selected = brepo.search(condition);
		// 기본 데이터에는 5개가 존재한다.
		assertEquals(selected.size(), 5);
	}
	
	@Test
	public void testByTitle() {
		// title에 싸피가 들어간 자료를 조회하는데 isbn 기준으로 내림차순 정렬한다.
		SearchCondition condition = new SearchCondition("title", "싸피", "isbn", "desc");
		List<Book> selected = brepo.search(condition);
		
		assertEquals(selected.size(), 10);
		assertEquals(selected.get(0).getIsbn(), "111-222-9999");
	}
	
	@Test
	public void testByContent() {
		// content에 공백이 있는 데이터를 isbn의 오름차순으로 1페이지 부터 조회한다.
		SearchCondition nav = new SearchCondition("content", " ", "isbn", "desc", 1);
		List<Book> selected = brepo.search(nav);
		assertEquals(selected.get(0).getIsbn(), "111-222-9999");
		assertEquals(selected.size(), 10);
	}
}
