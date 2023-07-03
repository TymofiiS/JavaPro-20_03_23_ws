package ua.ithillel.hw21;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SimpleListLib {
	
	public static Integer[] getTail(Integer[] input) {
		// Convert array to list
		List<Integer> list = Arrays.asList(input);
		
		// Check if contains 4
		int lastOccurance = list.lastIndexOf(4);
		if(lastOccurance < 0) {throw new RuntimeException();}
		
		// Return array from the last 4 to the end
		return
			(Integer[]) list
				.subList(lastOccurance, list.size()-1)
				.toArray();
	}
	
	public static boolean checkContent(Integer[] input) {	
		// Convert array to list
		List<Integer> list = Arrays.asList(input);
		
		// Remove all 1 and 4;
		list.removeAll(Collections.singleton(1));
		list.removeAll(Collections.singleton(4));		
		
		// Size must be 0
		return list.size() == 0;
	}
}
