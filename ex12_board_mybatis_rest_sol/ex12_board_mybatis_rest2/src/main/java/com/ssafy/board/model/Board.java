package com.ssafy.board.model;

import java.util.Date;

public class Board {
	private int num;
	private String writer;
	private String title;
	private String content;
	private String pwd;
	private int hit;
	//private Date regdate;
	private String regdate;
	
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
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
//	public Date getRegdate() {
//		return regdate;
//	}
//	public void setRegdate(Date regdate) {
//		this.regdate = regdate;
//	}
}
