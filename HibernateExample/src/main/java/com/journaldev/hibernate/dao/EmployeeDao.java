package com.journaldev.hibernate.dao;

import com.journaldev.hibernate.model.Employee;

public class EmployeeDao extends DaoBase<Employee, Integer> {	
	
	public EmployeeDao() {
		super(Employee.EMPLOYEE_TABLE_NAME, Employee.class);
	}
}
