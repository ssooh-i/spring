package sample2;

//의존 관계를 약하게 설정하는 프로그램(결합도를 낮춤)
public class HelloSpring {
	public static void main(String[] args) {
		MessageBean bean=new MessageBeanEn();
		//bean.sayHello(" 스프링!!");
		bean.sayHello(" Spring!!");
	}
}
