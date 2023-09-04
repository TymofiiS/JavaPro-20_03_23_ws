package ua.ithillel.hw25_6.springbootfirst.web.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.ithillel.hw25_6.springbootfirst.models.Employee;
import ua.ithillel.hw25_6.springbootfirst.models.EmployeeDto;
import ua.ithillel.hw25_6.springbootfirst.services.EmployeeService;


@RestController
@RequestMapping(value = "/api")
public class EmployeeRestController {

	private final EmployeeService employeeService;	
	
	public static final Logger logger = 
			LoggerFactory.getLogger(EmployeeRestController.class);
	
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping(
			value = "/emp",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EmployeeDto> findAll(){
		List<Employee> resEmployees = employeeService.findAll();		
		return toDao(resEmployees);
	}
	
	@GetMapping(value = "/first")
	public ResponseEntity<Employee> first(){
		List<Employee> resEmployees = employeeService.findAll();
		return ResponseEntity.ok(resEmployees.get(0));
	}
	
	
	@PostMapping(
			value = "/add", 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeDto> create(@RequestBody EmployeeDto dto) {
		employeeService.create(
				new Employee(0, dto.getName(), dto.getRole()));
		
		List<Employee> resEmployees = employeeService.findAll();
		return ResponseEntity.ok(toDao(resEmployees).get(resEmployees.size()-1));
	}
	
	
	private List<EmployeeDto> toDao(List<Employee> resEmployees){
		return resEmployees
				.stream()
				.map(e -> new EmployeeDto(
						e.getId(), e.getName(), e.getRole()))
				.collect(Collectors.toList());
	}
}
