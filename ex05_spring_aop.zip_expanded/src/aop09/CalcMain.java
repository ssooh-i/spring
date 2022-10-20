package aop09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {
	public static void main(String[] args) {

		ApplicationContext factory = new ClassPathXmlApplicationContext("aop08/bean.xml");

		CalcMethod calc = factory.getBean("calc", CalcMethod.class);
		calc.sum(5, 4);
		calc.div(5, 0);

		((ClassPathXmlApplicationContext) factory).close();
	}
}
