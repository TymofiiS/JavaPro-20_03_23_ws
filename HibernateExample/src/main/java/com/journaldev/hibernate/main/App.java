package com.journaldev.hibernate.main;

import java.util.Date;
import java.util.List;

import com.journaldev.hibernate.dao.EmployeeDao;
import com.journaldev.hibernate.model.Employee;
import com.journaldev.hibernate.util.HibernateUtil;

public class App {

	public static void main(String[] args) {
		
		// Initiate DAO
		EmployeeDao employeeDao = new EmployeeDao();
		
		// CREATE
		for (int i=0; i<10;i++) {
			Employee emp = new Employee(
					"Lisa" + i, "Manager" + i, new Date());
			employeeDao.persist(emp);					
		}
				
		// READ	
		System.out.println("Initial state");
		List<Employee> employees = employeeDao.findAll();
        for(Employee model : employees) {
            System.out.println(model);
        }
		
		// DELETE
		for (int i=0; i<11;i+=2) {			
			employeeDao.delete(i);
		}
		
		// UPDATE
		int increment = 1;
		employees = employeeDao.findAll();
		for (Employee employee : employees) {
			employee.setRole("CEO" + increment++);
			employeeDao.update(employee);
		}
				
		// READ	
		System.out.println("Final state");
		employees = employeeDao.findAll();
        for(Employee model : employees) {
            System.out.println(model);
        }			
        
        // Close session factory
        HibernateUtil.closeSessionFactory();
	}

}
