package anno01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FoodTest {
	public static void main(String[] args) {
		ApplicationContext factory=new ClassPathXmlApplicationContext("anno01/bean1.xml");
		
		//MyFoodMgr ob=(MyFoodMgr)factory.getBean("myFood");
		MyFoodMgr ob=factory.getBean("myFood", MyFoodMgr.class);
		System.out.println(ob);
		
		((ClassPathXmlApplicationContext)factory).close();
	}
}
///MyFoodMgr [좋아하는 음식=Food [foodName=스파게티, foodPrice=7500], 싫어하는 음식=Food [foodName=보신탕, foodPrice=12000]]