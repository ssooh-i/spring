package anno04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DriverCar {
	public static void main(String[] args) {
		ApplicationContext factory=new ClassPathXmlApplicationContext("anno04/bean.xml");
		
		Tire tire=factory.getBean("koreaTire", KoreaTire.class);
		System.out.println(tire.getBrand());
		
		Car tire2=factory.getBean("carTire", Car.class);
		tire2.drive();
		
		((ClassPathXmlApplicationContext)factory).close();
	}
}
/*
[출력화면]
한국타이어
한국타이어로 만들어진 국산 자동차
*/