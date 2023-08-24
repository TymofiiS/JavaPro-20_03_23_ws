package ua.ithillel.hw25_1.web.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.ithillel.hw25_1.models.Employee;
import ua.ithillel.hw25_1.services.EmployeeService;

@RestController
@RequestMapping(value = "/emp")
public class EmployeeRestController {

	private final EmployeeService employeeService;	
	
	public static final Logger logger = 
			LoggerFactory.getLogger(EmployeeRestController.class);
	
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping
	public List<Employee> findAll(){
		List<Employee> resEmployees = employeeService.findAll();
		
		/*
		for (Employee employee : resEmployees) {
			logger.info(employee.toString());
		}
		*/
		
		return resEmployees;
	}
}
