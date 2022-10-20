package aop08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CoreMain {
	public static void main(String[] args) {
		ApplicationContext factory=new GenericXmlApplicationContext("aop08/bean.xml");
		
		CoreEx ex=factory.getBean("core", CoreEx.class);
		try {
			ex.zeroMethod(5,0);
		}catch(Exception e) {}
		
		((GenericXmlApplicationContext)factory).close();
	}
}
