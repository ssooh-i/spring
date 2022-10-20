package anno03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpTest {
	public static void main(String[] args) {
		ApplicationContext factory =
				new ClassPathXmlApplicationContext("anno03/bean.xml");
			
		Engineer ob=factory.getBean("engineer",Engineer.class);
		System.out.println(ob.toString());
		
		((ClassPathXmlApplicationContext)factory).close();
	}
}
//홍길동은 25세이고 입사점수는 75.4입니다
//개발부에 근무합니다
