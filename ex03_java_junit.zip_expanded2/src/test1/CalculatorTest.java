package test1;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	private Calculator ob;
	
	@BeforeEach
	public void setUp() {
		ob=new Calculator();
		System.out.println("setUp");
	}
	
	@AfterEach
	public void tearDown() {
		System.out.println("tearDown");
	}
	
	@Test
	@Disabled
	public void concatenate() {
		String s=ob.concatenate("abc", "가나다");
		assertEquals("abc가나다", s);
	}
	
	@Test
	public void add() {
		int s = ob.add(3, 5);
		assertEquals(8, s);
	}
	
	@Test
	public void subtract() {
		int s = ob.subtract(7, 3);
		assertEquals(4, s);
	}

}




