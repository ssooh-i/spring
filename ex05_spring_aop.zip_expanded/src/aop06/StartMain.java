package aop06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartMain {
	public static void main(String[] args) {
		ApplicationContext factory=new ClassPathXmlApplicationContext("aop06/applicationContext.xml");
		
		Person p=(Person)factory.getBean(args[0]);  // customer or emp
		p.work();	
		
		((ClassPathXmlApplicationContext)factory).close();
	}
}
