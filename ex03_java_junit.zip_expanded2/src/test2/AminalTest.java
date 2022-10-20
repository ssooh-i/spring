package test2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AminalTest {
	
	@Test
	public void test() {
		String ob1 = "강아지";
		String ob2 = "고양이";
		
		Animal n = new Animal(ob1);
		assertEquals(n.getAnimal(), ob1);
	}
}
