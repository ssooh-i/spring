import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnimalTestSpring {
	public static void main(String[] args) {
		
		//메타정보를 SpringFramework에게 넘겨줌
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/application.xml");
		
		//빈을 만들지 않는다. 얻어서 사용한다
		Animal animal = ctx.getBean(Dog.class);
		animal.bark();
		
		Cage c = ctx.getBean(Cage.class);
		c.useAnimal();
		
		Zoo zoo = ctx.getBean(Zoo.class);
		zoo.useAnimal();
		
		Cage zooCage = zoo.getCage();
		//ctx를 통해서 얻어온 객체는 싱글톤형태다(내부적으로)
		// ==은 두개가 정말로 같은 객체인가? 동일한 주소인가 판별
		System.out.println(zooCage == c);//true
	}
}
