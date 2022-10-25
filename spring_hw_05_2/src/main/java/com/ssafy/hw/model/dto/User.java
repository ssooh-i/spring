package com.ssafy.hw.model.dto;

public class User {

	private String id; // 아이디
	private String pass; // 비밀번호
	private String name; // 이름

	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public User(String id, String pass, String name) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", pass=" + pass + ", name=" + name + "]";
	}




}
