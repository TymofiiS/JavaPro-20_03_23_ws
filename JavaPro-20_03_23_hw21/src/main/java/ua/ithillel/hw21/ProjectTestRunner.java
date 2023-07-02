package ua.ithillel.hw21;

import java.util.ArrayList;
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
import org.junit.platform.reporting.legacy.xml.LegacyXmlReportGeneratingListener;


public class ProjectTestRunner {
	
	/*
	 * - для запуску тесту на ім'я класу (рядкове значення)
- для запуску тесту на ім'я класу (тип даних клас)
- для запуску тестів за іменами класів (рядкове значення)
- для запуску тестів за іменами класів ( тип даних клас)
- для запуску тестів за розташуванням у пакеті (рядкове значення)
	 */

	LauncherDiscoveryRequest request = null;
	List<PrintWriter> writers = new ArrayList<>();
	
	public <T> void testExecuteByClassType(Class<T> type) {
		
		if(type == null) return;
		
		request = LauncherDiscoveryRequestBuilder.request()
			    .selectors(
			        selectClass(type)
			    )
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
