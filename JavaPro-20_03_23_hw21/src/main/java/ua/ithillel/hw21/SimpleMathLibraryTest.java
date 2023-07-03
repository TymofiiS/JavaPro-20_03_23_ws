package ua.ithillel.hw21;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class SimpleMathLibraryTest {
	
	@Test
    public void simpleMathLibrary_add_pass() {
		boolean res = SimpleMathLibrary.add(1, 1) == 2;
		System.out.println(res?"OK":"NOK");
		assertEquals(true, res);
    }
	
	@Test
    public void simpleMathLibrary_add_notpass() {
		boolean res = SimpleMathLibrary.add(1, 0) == 2;
		System.out.println(res?"OK":"NOK");
		assertEquals(true, res);
    }
	
	@Test
    public void simpleMathLibrary_minus_pass() {
		boolean res = SimpleMathLibrary.minus(1, 1) == 0;
		System.out.println(res?"OK":"NOK");
		assertEquals(true, res);
    }
	
	@Test
    public void simpleMathLibrary_minus_notpass() {
		boolean res = SimpleMathLibrary.minus(1, 1) == 2;
		System.out.println(res?"OK":"NOK");
		assertEquals(true, res);
    }

}
