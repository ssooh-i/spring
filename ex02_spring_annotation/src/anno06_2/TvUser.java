package anno06_2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TvUser {
	public static void main(String[] args) {
		ApplicationContext factory=new ClassPathXmlApplicationContext("anno06_2/bean.xml");
		Tv tv=factory.getBean("lg",Tv.class);  // lg or samsung

		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		((ClassPathXmlApplicationContext)factory).close();		
	}
}









