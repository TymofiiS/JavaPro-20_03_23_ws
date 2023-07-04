package ua.ithillel.hw21;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

import java.io.BufferedReader;

public class TestResultParser {
	
	String testsFoundText = "tests found";
	String testsSucceededText = "tests succeeded";
	String testsFailedText = "tests failed";
	
	public void parse(Path filePath) {
		if(filePath == null) {return;}
		parse(filePath.toFile());
	}
	
	public void parse(String filePath) {
		if(filePath == null || filePath.length() == 0)
			{return;}
		File file = new File(filePath);
		parse(file);
	}

	public void parse(File file) {
		
    	if(file == null || !file.exists()){return;}
    	
		int testsFoundCount = 0;
		int testsSucceededCount = 0;
		int testsFailedCount = 0;
		
    	try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    	    String line;
    	    while ((line = br.readLine()) != null) {
    	       if (line.contains(testsFoundText)) {
    	    	   testsFoundCount = 
    	    			   countParser(line.replace(testsFoundText, ""));
    	       }
    	       if (line.contains(testsSucceededText)) {
    	    	   testsSucceededCount =
    	    			   countParser(line.replace(testsSucceededText, ""));
    	       }
    	       if (line.contains(testsFailedText)) {
    	    	   testsFailedCount =
    	    			   countParser(line.replace(testsFailedText, ""));
    	       }
    	    }
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		testResult = new TestResult(
				testsFoundCount,
				testsSucceededCount,
				testsFailedCount);
	}
	
	private int countParser(String str) {
		String temp = str.replace("[", "");
		temp = temp.replace("]", "");
		temp = temp.trim();
		
		int res;
		try {
		   res = Integer.parseInt(temp);
		}
		catch (NumberFormatException e) {
		   res = 0;
		}
		
		return res;
	}
	
	protected TestResult testResult;
	
	public TestResult getTestResult() {
		return testResult;
	}
}
