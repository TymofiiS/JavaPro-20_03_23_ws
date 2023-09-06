package ua.ithillel.hw25_7.springbootjdbc.repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import ua.ithillel.hw25_7.springbootjdbc.models.Employee;

@Repository
public interface EmployeeRepository 
	extends ListCrudRepository<Employee, Long>, EmployeeSearchRepository {
	
}
