/*
0. Створити проект.

1. У проекті додати папку libs

2. Завантажити залежність JUnit Platform Console Standalone з Maven Repository 
у вигляді jar-файлу (див. посилання в описі до уроку). 

2.1 Ознайомитись з детальною інформацією про залежність за посиланням 
https://junit.org/junit5/docs/current/user-guide/#running-tests-console-launcher

3. Додати jar-файл до папки libs та підключити проект у вигляді бібліотеки .

4. Створити клас TestRunner для запуску тестів. 

5. У класі ProjectTestRunner створити методи: 
- для запуску тесту на ім'я класу (рядкове значення)
- для запуску тесту на ім'я класу (тип даних клас)
- для запуску тестів за іменами класів (рядкове значення)
- для запуску тестів за іменами класів ( тип даних клас)
- для запуску тестів за розташуванням у пакеті (рядкове значення)

6. Створити клас SimpleMathLibrary. Клас містить дві операції: 
- Додавання (add) для двох аргументів. Повертається тип double.
- Віднімання (minus) для двох аргументів. Повертається тип double.

7. Створити клас SimpleMathLibraryTest. 
Клас містить метод-тести (сценарії) анотовані @Test

8. У класі SimpleMathLibraryTest реалізувати сценарії 
з перевіркою результат операцій:
- SimpleMathLibrary#add
- SimpleMathLibrary#minus 

Перевірка очікуваного результату здійснюється 
за допомогою умовного оператора.

Наприклад:
Якщо а == 2 тоді sout(“OK”), інакше sout(“NOK”)

9. Виконати програму із запуску тестів та вивести 
результат виконання в консоль.

Наприклад:
Test run finished after 64 ms
[ 5 containers found ]
[ 0 containers skipped ]
[ 5 containers started ]
[ 0 containers aborted ]
[ 7 containers successful ]
[ 0 containers failed ]
[ 6 tests found ]
[ 1 tests skip ]


10. * Виконати п.9, але також результат виконання записати у файл.


11. ** Створити клас TestResultParser із методом parse.
- для парсингу файлу по дорозі (рядкове значення)
- для парсингу файлу по дорозі (тип даних File)
- для парсингу файлу по дорозі (тип даних Path) 


12. ** Метод parse у класі TestResultParser виконують аналіз файлу, 
який потенційно може (ймовірно не містить) 
містити інформацію про виконання тестів. 


13. ** Після виконання парсингу, створити об'єкт TestResult, 
який містить наступну інформацію:
- Загальна кількість тестів
- Кількість успішно пройдених тестів
- Кількість провалених тестів
- Фактичний час запуску тестів (можна використовувати тип даних Date) 


14. Написати метод, якому як аргумент передається 
не порожній одновимірний цілісний масив. 
Метод повинен повернути новий масив, 
отриманий шляхом витягування з вихідного масиву елементів, 
що йдуть після останньої четвірки. 
Вхідний масив повинен містити хоча б одну четвірку, 
інакше в методі необхідно викинути RuntimeException.

Написати набір тестів цього методу (по 3-4 варіанти вхідних даних).

Наприклад: 
[1 2 4 4 2 3 4 1 7] -> вих: [1 7].


15. Написати метод, який перевіряє склад масиву з чисел 1 і 4. 
Якщо у ньому немає хоч однієї четвірки чи одиниці, 
то метод поверне false; 
Написати набір тестів цього методу (по 3-4 варіанти вхідних даних).

Наприклад:
[ 1 1 1 4 4 1 4 4 ] -> true
[ 1 1 1 1 1 1 ] -> false
[ 4 4 4 4 ] -> false
[ 1 4 4 1 1 4 3 ] -> false

*/


package ua.ithillel.hw21;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class TestRunner {

	public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
		
		System.out.println("hw21\n");
		
		System.out.println("\nProjectTestRunner\n");
		ProjectTestRunner projectTestRunner = 
				new ProjectTestRunner();
		
		projectTestRunner.addWriter(
				new PrintWriter(System.out));
		
		projectTestRunner.addWriter(
				new PrintWriter(
						new File("testReport.txt")));
		
		projectTestRunner.testExecuteByClassType(
				SimpleMathLibraryTest.class);
		
		projectTestRunner.testExecuteByClassName(
				SimpleMathLibraryTest.class.getName());
		
		projectTestRunner.testExecuteByClassNames(
				Arrays.asList(
						SimpleMathLibraryTest.class.getName()));
		
		projectTestRunner.testExecuteByClassTypes(
				Arrays.asList(
						SimpleMathLibraryTest.class));
		
		projectTestRunner.testExecuteByPackegeName(
				SimpleMathLibraryTest.class.getPackageName());
		
		System.out.println("\nTestResultParser\n");
		TestResultParser testResultParser = new TestResultParser();
		
		File starting = new File(System.getProperty("user.dir"));
		
		File fileToBeRead = new File(starting, "testReport.txt");	
		testResultParser.parse(fileToBeRead);
		System.out.println(testResultParser.getTestResult());	
		
		Path path =  Paths.get(fileToBeRead.getAbsolutePath());
		testResultParser.parse(path);
		System.out.println(testResultParser.getTestResult());
		
		testResultParser.parse(fileToBeRead.getAbsolutePath());
		System.out.println(testResultParser.getTestResult());
		
	}

}
