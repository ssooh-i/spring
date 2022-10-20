package aop09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CalcMain {
	public static void main(String[] args) {
		ApplicationContext factory = new GenericXmlApplicationContext("aop09/bean.xml");

		CalcMethod calc = factory.getBean("calc", CalcMethod.class);

		try {
			calc.sum(5, 4);
			System.out.println();
			calc.div(2, 0);
		} catch (Exception e) {
		}

		((GenericXmlApplicationContext) factory).close();
	}

}
