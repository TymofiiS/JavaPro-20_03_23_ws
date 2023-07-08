package ua.ithillel.hw21;

import java.time.LocalDateTime;

public class TestResult {

	@Override
	public String toString() {
		return "TestResult ["
				+ "testsCount=" + testsCount 
				+ ", succeededCount=" + succeededCount 
				+ ", failedCount="+ failedCount 
				+ ", executionTime=" + executionTime + "]";
	}

	private int testsCount;
	private int succeededCount;
	private int failedCount;
	private LocalDateTime executionTime;
	
	public TestResult(
			int testsCount, 
			int succssesCount, 
			int failedCount) {
		this.testsCount = testsCount;
		this.succeededCount = succssesCount;
		this.failedCount = failedCount;
		this.executionTime = java.time.LocalDateTime.now();
	}
	
}
