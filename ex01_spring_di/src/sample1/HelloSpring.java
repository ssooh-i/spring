package sample1;

//결합도가 높은 프로그램
public class HelloSpring {
	public static void main(String[] args) {
		MessageBean bean=new MessageBean();
		//bean.sayHello(" 스프링!!");
		bean.sayHello(" Spring!!");
	}
}
