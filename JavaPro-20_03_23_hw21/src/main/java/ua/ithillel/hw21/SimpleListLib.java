package ua.ithillel.hw21;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleListLib {
	
	public static Integer[] getTail(Integer[] input) {
		// Convert array to list
		List<Integer> list = Arrays.asList(input);
		
		// Check if contains 4
		int lastOccurance = list.lastIndexOf(4);
		if(lastOccurance < 0) {throw new RuntimeException();}
		
		// Check if 4 is not the last one
		if(lastOccurance + 1 > list.size() - 1) {
			return new Integer[0];
		}
		
		// Return array from the last 4 to the end	
		List<Integer> res = list
				.subList(lastOccurance + 1, list.size());
		
    	Integer[] finalResult = new Integer[res.size()];
    	res.toArray(finalResult);
    			
    	return finalResult;
	}
	
	public static Boolean checkContent(Integer[] input) {	
		// Convert array to list
		List<Integer> listInit = Arrays.asList(input);

		// Remove all 1 and 4;
		List<Integer> list = listInit.stream()
				.filter(x -> x != 4 && x != 1)
				.collect(Collectors.toList());		

		return list.size() == 0 && 
				listInit.indexOf(4) >=0 && 
				listInit.indexOf(1) >=0;
	}
	

}
