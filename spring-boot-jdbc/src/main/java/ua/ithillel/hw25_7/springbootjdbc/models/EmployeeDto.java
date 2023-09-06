package ua.ithillel.hw25_7.springbootjdbc.models;


public class EmployeeDto {

	private Long id;
	
	private String name;
	
	private String role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public EmployeeDto(Long id, String name, String role) {
		this.id = id;
		this.name = name;
		this.role = role;
	}

	public EmployeeDto() {
	}

	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", name=" + name + ", role=" + role + "]";
	}
	
	
}
