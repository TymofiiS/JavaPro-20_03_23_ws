package ua.ithillel.hw25_1.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.ithillel.hw25_1.models.Employee;

@Repository
public class EmployeeDao  {	
	
	private final JdbcTemplate jdbcTemplate;
	
	public EmployeeDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Employee> findAll(){
		return this.jdbcTemplate.query(
				"SELECT * FROM employee", 
				new BeanPropertyRowMapper<>(Employee.class));
	}
	
	/*
    public void save(UserEntity entity) {

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("login", entity.getLogin());
        parameters.put("password", entity.getPassword());

        SimpleJdbcInsert simpleJdbcInsert = this.simpleJdbcInsert.withTableName("\"user\"")
                .usingColumns("login", "password")
                .usingGeneratedKeyColumns("id");

        Number id = simpleJdbcInsert.executeAndReturnKey(parameters);

        entity.setId(id.longValue());

    }
    */
}
