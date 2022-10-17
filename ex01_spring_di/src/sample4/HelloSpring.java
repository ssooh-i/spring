package sample4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("sample4/bean2.xml");
		System.out.println("** container 초기화 작업 **");
		
		MessageBean bean=(MessageBean)context.getBean("messageBean");
		bean.sayHello();                  // 주입(DI)  
		bean.sayHello("banana", 1500);    // 대입
		
		((ClassPathXmlApplicationContext)context).close();		
	}
}
