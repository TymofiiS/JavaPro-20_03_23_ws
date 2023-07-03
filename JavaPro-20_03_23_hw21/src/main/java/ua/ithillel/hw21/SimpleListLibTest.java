package ua.ithillel.hw21;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SimpleListLibTest {
	
	@Test
	@ParameterizedTest
	@CsvSource({
		"[1 2 4 4 2 3 4 1 7],[1 7]"})
	public void SimpleListLib_getTail_pass(
			Integer[] input, Integer[] expected) {
	    Integer[] actualValue = SimpleListLib.getTail(input);
	    Assertions.assertEquals(expected, actualValue);
	}

}
