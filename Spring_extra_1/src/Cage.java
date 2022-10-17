
public class Cage {
	//has a 관계
	//new를 하는 순간 -> 의존성 발생 -> 스프링에서는 하지말자!
//	private Animal animal = new Dog("달달이");
	private Animal animal;
	
	//멤버변수에 대한 초기화 - 생성자, setter
	public Cage(Animal animal) {
		this.animal = animal;
	}
	
	public void useAnimal() {
		animal.bark();
	}
}
