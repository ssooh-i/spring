
public class AnimalTestOld {
	public static void main(String[] args) {
		//고양이가 아니라 강아지를 키우고 싶어
//		Animal animal = new Cat();
		//의존성에 해당하는 객체를 직접생성 -> 관리 책임
		Animal animal = new Dog("진돌이"); //Animal이 Dog나 Cat이냐에 따라서 코드가 변경되어야함 -> 의존성 높음
		animal.bark();
		
		//직접 객체도 생성하고, 객체간의 관계도 맺어줘야함 (바쁨)
		Cage c = new Cage(new Cat());
		c.useAnimal();
		
		Zoo zoo = new Zoo("과천어린이대공원");
		zoo.setCage(c);
	}
}
