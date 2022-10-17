package sample6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMain {
	public static void main(String[] args) {
		ApplicationContext factory
			    =new ClassPathXmlApplicationContext("sample6/bean1.xml");
		
//		Emp b1=(Emp)factory.getBean("developer");
//		System.out.println(b1.toString());
		
		Emp b1=factory.getBean("developer", Developer.class);
		System.out.println(b1);
		
		Emp b2=(Emp)factory.getBean("engineer");
		System.out.println(b2.toString());
		
		((ClassPathXmlApplicationContext)factory).close();
	}
}
/*
이름 : 강호동   급여 : 1500000   부서 : 개발1팀(개발부)
이름 : 이순신   급여 : 2500000   부서 : 기술1팀(기술부)
*/




