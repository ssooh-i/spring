package anno05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/* 
@Autowired: 스프링 전용, type으로 찾는다.
@Resource: 자바전용, 먼저 name으로 찾고 없으면 type으로 찾는다.*/

@Component(value = "mySchool")
public class School {
	@Autowired
	public Student person;
	
	@Autowired
	@Qualifier(value="grade1")
	public int grade;
	
	@Override
	public String toString() {
		return "ABC고등학교 [학생정보=" + person.toString() + "학년=" + grade + "]";
	}
}
/*
School.java
    +person:Student
    +grade:int
    +School()
    +School(person:Student)
    +toString():String
        "ABC고등학교 [학생정보=" + person.toString() + "학년=" + grade + "]"
*/