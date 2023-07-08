package ua.ithillel.hw21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


public class SimpleMathLibraryTest {
	
	@Test
    public void simpleMathLibrary_add_pass() {
		boolean res = SimpleMathLibrary.add(1, 1) == 2;
		System.out.println(res?"OK":"NOK");
		Assertions.assertEquals(true, res);
    }
	
	@Test
    public void simpleMathLibrary_add_notpass() {
		boolean res = SimpleMathLibrary.add(1, 0) == 2;
		System.out.println(res?"OK":"NOK");
		Assertions.assertEquals(true, res);
    }
	
	@Test
    public void simpleMathLibrary_minus_pass() {
		boolean res = SimpleMathLibrary.minus(1, 1) == 0;
		System.out.println(res?"OK":"NOK");
		Assertions.assertEquals(true, res);
    }
	
	@Disabled
	@Test
    public void simpleMathLibrary_minus_disabled() {
		boolean res = SimpleMathLibrary.minus(1, 1) == 2;
		System.out.println(res?"OK":"NOK");
		Assertions.assertEquals(true, res);
    }

}
