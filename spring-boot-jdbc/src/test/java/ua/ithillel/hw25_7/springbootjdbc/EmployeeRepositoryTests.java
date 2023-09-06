package ua.ithillel.hw25_7.springbootjdbc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import ua.ithillel.hw25_7.springbootjdbc.models.Employee;
import ua.ithillel.hw25_7.springbootjdbc.repositories.EmployeeRepository;

@SpringBootTest
public class EmployeeRepositoryTests {
	
	public static final Logger logger = 
			LoggerFactory.getLogger(EmployeeRepositoryTests.class);
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Test
	@Transactional
	public void saveTest() {
		Employee before = new Employee(null, "test", "test");
		assertThat(before.getId()).isNull();

		Employee after = employeeRepository.save(before);

		assertThat(after.getId()).isNotNull();
	}
	
	@Test
	@Transactional
	public void allByContainNameTest() {
		
		// Test part name
		String partName = "TestPartName";
		
		// Add test data
		for (int i = 0; i < 5; i++) {
			employeeRepository.save(
					new Employee(null, partName+i, "test"));		
		}
		
		// Get data with part name
		List<Employee> after = 
				employeeRepository.allByContainName(partName);

		for (Employee employee : after) {
			logger.info(employee.toString());
		}
		
		assertThat(after.size()).isEqualTo(5);
	}

}
