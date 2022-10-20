package aop07;

//Target Bean(타겟대상)
public class MessageBeanImpl implements MessageBean{
	private String name;
	
	public void setName(String name){
		this.name=name;
	}
	
	@Override
	public void sayHello() {
		try{
			Thread.sleep(3000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("Hello, " + name + "!!");
	}
}


