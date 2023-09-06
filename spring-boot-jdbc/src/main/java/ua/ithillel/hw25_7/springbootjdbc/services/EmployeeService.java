package ua.ithillel.hw25_7.springbootjdbc.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.ithillel.hw25_7.springbootjdbc.dao.EmployeeDao;
import ua.ithillel.hw25_7.springbootjdbc.models.Employee;
import ua.ithillel.hw25_7.springbootjdbc.repositories.EmployeeRepository;


@Service
@Transactional
public class EmployeeService {
		
	private final EmployeeRepository employeeRepository;
	private final EmployeeDao employeeDao;
	
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}
	
	public List<Employee> findAllByPartName(String partName){
		return employeeRepository.allByContainName(partName);
	}

	public Employee create(Employee emp) {		
		return employeeRepository.save(emp);
	}

	public EmployeeService(
			EmployeeRepository employeeRepository, 
			EmployeeDao employeeDao) {
		this.employeeRepository = employeeRepository;
		this.employeeDao = employeeDao;
	}
}
