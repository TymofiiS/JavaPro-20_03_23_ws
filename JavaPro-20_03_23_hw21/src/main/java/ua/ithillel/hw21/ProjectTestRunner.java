package ua.ithillel.hw21;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class ProjectTestRunner {
	
	/*
	 * - для запуску тесту на ім'я класу (рядкове значення)
- для запуску тесту на ім'я класу (тип даних клас)
- для запуску тестів за іменами класів (рядкове значення)
- для запуску тестів за іменами класів ( тип даних клас)
- для запуску тестів за розташуванням у пакеті (рядкове значення)
	 */
	
	public <T> void TestExecuteByClassType(Class<T> type) {
		Result result = JUnitCore.runClasses(type);
		
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
			
	      System.out.println(result.wasSuccessful());
	}

}
