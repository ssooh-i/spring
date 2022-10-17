
public class Zoo {
	private String name;// 생성자, constructor
	private Cage cage;// setter

	public Zoo(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setCage(Cage cage) {
		this.cage = cage;
	}

	public Cage getCage() {
		return cage;
	}
	
	public void useAnimal() {
		cage.useAnimal();
	}
}
