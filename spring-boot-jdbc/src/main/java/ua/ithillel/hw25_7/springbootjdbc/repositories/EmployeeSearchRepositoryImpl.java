package ua.ithillel.hw25_7.springbootjdbc.repositories;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.ithillel.hw25_7.springbootjdbc.models.Employee;

@Repository
public class EmployeeSearchRepositoryImpl implements EmployeeSearchRepository {

	public EmployeeSearchRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private final JdbcTemplate jdbcTemplate;
			
	@Override
	public List<Employee> allByContainName(String name) {
		
		return this.jdbcTemplate.query(
				"SELECT * FROM employee "
				+ "WHERE NAME LIKE '%" + name + "%'", 
				new BeanPropertyRowMapper<>(Employee.class));
	}

}
