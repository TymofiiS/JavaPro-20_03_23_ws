package ua.ithillel.hw25_7.springbootjdbc.repositories;

import java.util.List;

import ua.ithillel.hw25_7.springbootjdbc.models.Employee;

public interface EmployeeSearchRepository {
	List<Employee> allByContainName(String name);
}
