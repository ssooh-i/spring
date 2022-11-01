package com.ssafy.board.model;

import java.time.LocalDateTime;

public class BoardDto {
//	DB 저장되어있는 변수  
//	num       int        primary key auto_increment,
//	writer    varchar(12)  not null,
//	title     varchar(50)  not null,
//	content   varchar(4000),
//	pwd       varchar(12)  not null,
//	hit       int       not null,
//	regdate   date          not null default (current_date())

	private int num; // = articleNo
	private String writer; // = userId
	private String title; // = subject
	private String content;
	private String pwd;
	private int hit;
	private LocalDateTime regdate; // = registerTime

	public BoardDto() {
		this.regdate = LocalDateTime.now();

	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "BoardDao [num=" + num + ", writer=" + writer + ", title=" + title + ", content=" + content + ", pwd="
				+ pwd + ", hit=" + hit + ", regdate=" + regdate + "]";
	}

}
