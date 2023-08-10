package com.journaldev.hibernate.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.journaldev.hibernate.model.Employee;
import com.journaldev.hibernate.util.HibernateUtil;

public class HibernateJavaConfigMain {

	public static void main(String[] args) {
		
		//Get Session
		SessionFactory sessionFactory = 
				HibernateUtil.getSessionJavaConfigFactory();
		Session session = 
				sessionFactory.getCurrentSession();
				
		//start transaction
		session.beginTransaction();
		
		// CREATE
		for (int i=0; i<10;i++) {
			Employee emp = new Employee();
			emp.setName("Lisa" + i);
			emp.setRole("Manager" + i);
			emp.setInsertTime(new Date());
			
			session.save(emp);					
		}
				
		// READ		
		for (int i=0; i<11;i++) {
			Employee emp = 
					(Employee) session.get(Employee.class, i);
			
			if(emp == null) {continue;}
			
			System.out.println(emp);			
		}
		
		// DELETE
		for (int i=0; i<11;i+=2) {
			Employee emp = 
					(Employee) session.get(Employee.class, i);
			
			if(emp == null) {continue;}
			
			session.delete(emp);
		}
		
		// UPDATE
		for (int i=0; i<11;i++) {
			Employee emp = 
					(Employee) session.get(Employee.class, i);
			
			if(emp == null) {continue;}
			
			emp.setRole("CEO" + i);
			session.save(emp);
		}
		
		// READ		
		for (int i=0; i<11;i++) {
			Employee emp = 
					(Employee) session.get(Employee.class, i);
			
			if(emp == null) {continue;}
			
			System.out.println(emp);			
		}
				
		//Commit transaction
		session.getTransaction().commit();
		
		//terminate session factory, otherwise program won't end
		sessionFactory.close();
	}

}
