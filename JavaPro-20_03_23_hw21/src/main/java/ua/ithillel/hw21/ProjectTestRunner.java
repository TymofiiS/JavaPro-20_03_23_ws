package ua.ithillel.hw21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.platform.engine.FilterResult;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryListener;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.LauncherSession;
import org.junit.platform.launcher.LauncherSessionListener;
import org.junit.platform.launcher.PostDiscoveryFilter;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherConfig;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import org.junit.platform.engine.DiscoverySelector;

public class ProjectTestRunner {
	
	private LauncherDiscoveryRequest request = null;
	private List<PrintWriter> writers = new ArrayList<>();
	
	public <T> void testExecuteByClassTypes(List<Class<T>> types) {			
		if(types == null || types.size() == 0) 
			{return;}
		
		List<String> typeNames = new ArrayList<>();
		for (Class<T> type : types) {
			if(type == null) {continue;}
			typeNames.add(type.getName());
		}
		
		testExecuteByClassNames(typeNames);
	}
	
	public <T> void testExecuteByClassType(Class<T> type) {			
		if(type == null) {return;}			
		testExecuteByClassName(type.getName());
	}
	
	public void testExecuteByClassName(String typeName) {	
		List<String> typeNames = Arrays.asList(typeName); 
		testExecuteByClassNames(typeNames);
	}
	
	public void testExecuteByPackegeName(String packageName) {
		
		if(packageName == null || packageName.length() == 0) 
			{return;}
		
		request = LauncherDiscoveryRequestBuilder
				.request()
			    .selectors(selectPackage(packageName))
			    .build();
		
		printResult();
	}
	
	public void testExecuteByClassNames(List<String> typeNames) {
		
		List<DiscoverySelector> selectors = new ArrayList<>();
		
		for (String typeName : typeNames) {
			
			if(typeName == null || typeName.length() == 0) 
				{continue;}

			selectors.add(selectClass(typeName));
		}
				
		request = LauncherDiscoveryRequestBuilder
				.request()
			    .selectors(selectors)
			    .build();
		
		printResult();
	}

	public void addWriter(PrintWriter writer) {
		if(writer == null) {return;}
		this.writers.add(writer);
	}
	
	public void removeWriter(PrintWriter writer) {
		if(writer == null) {return;}
		this.writers.remove(writer);
	}

	private void printResult() {	
		
		SummaryGeneratingListener listener = 
				new SummaryGeneratingListener();

		try (LauncherSession session = LauncherFactory.openSession()) {
		    Launcher launcher = session.getLauncher();
		    // Register a listener of your choice
		    launcher.registerTestExecutionListeners(listener);
		    // Discover tests and build a test plan
		    TestPlan testPlan = launcher.discover(request);
		    // Execute test plan
		    launcher.execute(testPlan);
		    // Alternatively, execute the request directly
		    launcher.execute(request);
		}

		TestExecutionSummary summary = listener.getSummary();	
		
		long ellapsedTime = 
				summary.getTimeFinished() - summary.getTimeStarted();
		
		for (PrintWriter writer : writers) {
		    writer.write("\nTest run finished after " + ellapsedTime + " ms\n"); 
		    writer.write("[ " + summary.getContainersFoundCount() + " containers found ]\n");
		    writer.write("[ " + summary.getContainersSkippedCount() + " containers skipped ]\n");
		    writer.write("[ " + summary.getContainersStartedCount() + " containers started ]\n");
		    writer.write("[ " + summary.getContainersAbortedCount()+ " containers aborted ]\n");
		    writer.write("[ " + summary.getContainersSucceededCount() + " containers successful ]\n");
		    writer.write("[ " + summary.getContainersFailedCount() + " containers failed ]\n");
		    writer.write("[ " + summary.getTestsFoundCount() + " tests found ]\n");
		    writer.write("[ " + summary.getTestsSkippedCount() + " tests skip ]\n");
		    writer.flush();  
		    //writer.close(); 
		}
	}
	
}
