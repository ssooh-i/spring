package sample5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FooTestApp {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("sample5/bean2.xml");
		System.out.println("** Container 초기화 작업 **");
		//InterFoo에는 아무것도 안들었음, 해쉬코드가 실행됨 -> 싱글톤으로 만들어서 재사용하는 거여서 주소가 같음 static
		InterFoo ob1=(InterFoo)factory.getBean("f0");
		System.out.println(ob1);
		
		InterFoo ob2=(InterFoo)factory.getBean("f0");
		System.out.println(ob2);
		
		InterFoo ob3=(InterFoo)factory.getBean("f0");
		System.out.println(ob3);
		
		((ClassPathXmlApplicationContext) factory).close();
	}
}
