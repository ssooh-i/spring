package com.ssafy.emp.model;

//기본생성자, 인자4개받는 생성자, setter&getter
public class Emp {
	private int eno;
	private String ename;
	private String phone;
	private String dept;
	
	public Emp() {
		super();
	}
	public Emp(int eno, String ename, String phone, String dept) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.phone = phone;
		this.dept = dept;
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
}
