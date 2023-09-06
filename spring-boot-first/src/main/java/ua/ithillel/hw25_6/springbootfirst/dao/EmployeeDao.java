package ua.ithillel.hw25_6.springbootfirst.dao;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import ua.ithillel.hw25_6.springbootfirst.models.Employee;


@Repository
public class EmployeeDao  {	
	
	private final JdbcTemplate jdbcTemplate;
	private final SimpleJdbcInsert simpleJdbcInsert;
	
	public EmployeeDao(
			JdbcTemplate jdbcTemplate,
			DataSource dataSource) {
		
		this.jdbcTemplate = jdbcTemplate;
		this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
				.withTableName("employee")
				.usingGeneratedKeyColumns("id");
	}
	
	public List<Employee> findAll(){
		
		return this.jdbcTemplate.query(
				"SELECT * FROM employee", 
				new BeanPropertyRowMapper<>(Employee.class));
	}

	public void save(Employee emp) {	
		
		SqlParameterSource parameters = new MapSqlParameterSource()
				.addValue("name", emp.getName())
				.addValue("role", emp.getRole());
		Number newId = simpleJdbcInsert.executeAndReturnKey(parameters);
		emp.setId(newId.intValue());		
	}
}
