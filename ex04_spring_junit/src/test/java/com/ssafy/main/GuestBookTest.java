package com.ssafy.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.DisabledIf;

import com.ssafy.model.GuestBookDto;
import com.ssafy.model.MemberDto;
import com.ssafy.model.service.GuestBookService;
import com.ssafy.model.service.LoginService;

public class GuestBookTest extends AbstractTest {
	private Logger logger = LoggerFactory.getLogger(GuestBookTest.class);

	@Autowired
	private GuestBookService guestbookService;
	
	@Autowired
	private LoginService loginService;
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Class실행시 최초 한번");
	}
	
	@Before
	public void beforeMethod() {
		System.out.println("이전에 공통으로 실행");
	}
	
	@Test
	public void objectNotNull() {
		assertNotNull(guestbookService);
	}
	
	@Test
	@Ignore
	public void insertTest() {
		GuestBookDto guestBookDto = new GuestBookDto();
		guestBookDto.setSubject("제목이다2!!!");
		guestBookDto.setContent("내용이다2");
		try {
			guestbookService.writeArticle(guestBookDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void listTest() {
		try {
			List<GuestBookDto> list = guestbookService.listArticle("", "");
			logger.info("리스트 갯수 : {}", list.size());
			assertEquals(4, list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void loginTest() {
		try {
			MemberDto memberDto = loginService.login("ssafy", "ssafy");
			assertNotNull(memberDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
