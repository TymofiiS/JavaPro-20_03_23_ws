package com.journaldev.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.journaldev.hibernate.model.Employee;
import com.journaldev.hibernate.util.HibernateUtil;

public class  EmployeeDao {

	private HibernateUtil hUtil;
	
	public EmployeeDao() {
		hUtil = new HibernateUtil();
	}
	
    public void persist(Employee entity) {
    	Session session = hUtil.openCurrentSessionwithTransaction();
    	if(session == null) {return;}
    	
    	session.save(entity);
    	
        hUtil.closeCurrentSessionwithTransaction();
    }
 
    public void update(Employee entity) {
    	Session session = hUtil.openCurrentSessionwithTransaction();
    	if(session == null) {return;}
    	
    	session.update(entity);
    	
        hUtil.closeCurrentSessionwithTransaction();
    }
 
    public Employee findById(int id) {
    	Session session = hUtil.openCurrentSession();
    	if(session == null) {return null;}
    	
		Employee emp = 
				(Employee) session.get(Employee.class, id);
    	
        hUtil.closeCurrentSession();
        return emp;
    }
 
    public void delete(int id) {
    	Session session = hUtil.openCurrentSessionwithTransaction();
    	if(session == null) {return;}
    	
		Employee emp = 
				(Employee) session.get(Employee.class, id);
		if(emp != null) {session.delete(emp);}
    	
        hUtil.closeCurrentSessionwithTransaction();    	
    }
 
    @SuppressWarnings("unchecked")
	public List<Employee> findAll() {
    	Session session = hUtil.openCurrentSession();
    	if(session == null) {return new ArrayList<Employee>();}
    	
        List<Employee> employees = 
        		(List<Employee>) session
        			.createQuery("from Employee")
        			.list();
        hUtil.closeCurrentSession();
        
        return employees;
    }
}
