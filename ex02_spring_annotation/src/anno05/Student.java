package anno05;

public class Student {
	private String name;
	private String address;
	private int age;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", address=" + address + ", age=" + age + "]";
	}
}
/*
Student.java
	-name:String
	-address:String
	-age:int
	+setter
	+toString():String
		"Student [name=" + name + ", address=" + address + ", age=" + age + "]"
*/