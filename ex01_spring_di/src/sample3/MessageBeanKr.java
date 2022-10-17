package sample3;

public class MessageBeanKr  implements MessageBean{
	@Override
	public void sayHello(String name) {
		System.out.println("헬로우," + name);		
	}
}
