package ua.ithillel.hw25_7.springbootjdbc.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table("employee")
public class Employee {

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", role=" + role + "]";
	}
	
	@Id
	private Long id;
	
	private String name;
	
	private String role;
	
	public Employee(Long id, String name, String role) {
		this.id = id;
		this.name = name;
		this.role = role;
	}
	
	public Employee() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long i) {
		this.id = i;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
