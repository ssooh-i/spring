package test4;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/*   @BeforeEach   : BadingMachine객체생성
 *   @AfterEach    : 잔돈표시
 *   @Test         :  testInsertCoin  <-- 500,100,100주입한후
 *                                              현재 금액확인    
 *   @Test         : testNegativeCoin  <--  -100주입                                          
 */
public class BandingMachineTest {
	private BandingMachine bm;
	
	@BeforeEach
	public void setUp(){
		bm=new BandingMachine();
	}
	
	@AfterEach
	public void tearDown(){
		Assert.assertEquals(700, bm.getCurrent());
	}
	
	@Test
	@Disabled
	public void testInsertCoin(){
		bm.insertCoin(500);
		bm.insertCoin(100);
		bm.insertCoin(100);
		//Assert.assertEquals(700, bm.getCurrent());
	}
	
	@Test
	@Disabled
    public void testNegativeCoin(){
		
        assertThrows(RuntimeException.class,()->bm.insertCoin(-100));
    }
}







