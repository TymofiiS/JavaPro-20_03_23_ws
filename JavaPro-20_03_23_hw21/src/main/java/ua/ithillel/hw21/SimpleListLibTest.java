package ua.ithillel.hw21;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SimpleListLibTest {
	
    static Integer[] strToIntArr(String str) {
    	
    	str = str.replace("[", "");
    	str = str.replace("]", "");
    	
    	List<Integer> res = Arrays.stream(str.split(","))
    			.map(s -> Integer.parseInt(s.trim()))
    			.collect(Collectors.toList());
    	
    	Integer[] finalResult = new Integer[res.size()];
    	res.toArray(finalResult);
    			
    	return finalResult;
    }
    
    static String intArrToStr(Integer[] arr) {
    	
    	var res = Arrays.asList(arr)
    			.stream()
    			.map(Object::toString)
    			.collect(Collectors.joining(","));
    	
    	return "[" + res + "]";
    }
    
    @ParameterizedTest
    @MethodSource("testCases")
    public void SimpleListLib_getTail_pass(
    		String input, String expected) {
    	
        String actualValue = intArrToStr(
        		SimpleListLib.getTail(strToIntArr(input)));
        
        Assertions.assertEquals(expected, actualValue);
    }
    
    private static Stream<Arguments> testCases() {
        return Stream.of(
          Arguments.of("[1,2,3,4,5,6,7]", "[5,6,7]"),
          Arguments.of("[1,2,4,4,2,3,4,1,7]", "[1,7]"),
          Arguments.of("[1,2,3,4]", "[]")
        );
    }

    @Test
    public void SimpleListLib_getTail_exeption_pass() {
    	
    	Assertions.assertThrows(RuntimeException.class, () -> {
    		SimpleListLib.getTail(strToIntArr("[5,6,7]"));
        });
    }
    
    @ParameterizedTest
    @MethodSource("testCases1")
    public void SimpleListLib_checkContent_pass(
    		String input, Boolean expected) {
    	
        Boolean actualValue = 
        		SimpleListLib.checkContent(strToIntArr(input));
        
        Assertions.assertEquals(expected, actualValue);
    }
    
    private static Stream<Arguments> testCases1() {
        return Stream.of(
          Arguments.of("[1,1,1,4,4,1,4,4]", true),
          Arguments.of("[1,1,1,1,1,1,1]", false),
          Arguments.of("[4,4,4,4,4]", false),
          Arguments.of("[1,4,4,1,1,4,3]", false)
        );
    }

}
