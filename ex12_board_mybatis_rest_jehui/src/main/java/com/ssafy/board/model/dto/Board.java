package com.ssafy.board.model.dto;

import java.time.LocalDateTime;

public class Board {
	private int num;
	private String writer;
	private String title;
	private String content;
	private String pwd;
	private int hit;
	private String regdate;
	
	public Board() {
		super();
	}

	public Board(int num, String writer, String title, String content, String pwd, int hit, String regdate) {
		super();
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.pwd = pwd;
		this.hit = hit;
		this.regdate = regdate;
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

	public String getRegDate() {
		return regdate;
	}

	public void setRegDate(String regDate) {
		this.regdate = regDate;
	}

	@Override
	public String toString() {
		return "Board [number=" + num + ", writer=" + writer + ", title=" + title + ", content=" + content + ", pwd="
				+ pwd + ", hit=" + hit + ", insertDate=" + regdate + "]";
	}
}
