package ua.ithillel.hw25_1.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.ithillel.hw25_1.dao.EmployeeDao;
import ua.ithillel.hw25_1.models.Employee;

@Service
@Transactional
public class EmployeeService {
	
	public EmployeeService(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	private final EmployeeDao employeeDao;
	
	public List<Employee> findAll(){
		return employeeDao.findAll();
	}

	public void create(Employee emp) {
		employeeDao.save(emp);
	}
}
