package anno05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SchoolMain {
	public static void main(String[] args) {
		ApplicationContext factory= new ClassPathXmlApplicationContext("anno05/bean.xml");
		
		School sh=(School)factory.getBean("mySchool");
		System.out.println(sh.toString());
				
		((ClassPathXmlApplicationContext)factory).close();
	}
}
/*
[출력화면]
    ABC고등학교[학생정보 = Student [name=홍길동, address=부산, age=19], 학년=3] 
*/