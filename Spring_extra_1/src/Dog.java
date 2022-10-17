
public class Dog implements Animal {
	
	private String name;
	
	public Dog(String name) {
		System.out.println(name + "가 멍멍한다");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void bark() {
		System.out.println("멍멍");
		
	}

	
}
