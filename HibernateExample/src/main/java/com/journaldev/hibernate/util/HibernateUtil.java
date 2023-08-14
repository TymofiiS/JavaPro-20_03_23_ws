package com.journaldev.hibernate.util;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.journaldev.hibernate.model.Employee;

public class HibernateUtil {

	private static  SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
    	try {
	    	Configuration configuration = new Configuration();
			
			Properties props = new Properties();
			props.put("hibernate.hbm2ddl.auto", "create");
			props.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
			props.put("hibernate.connection.url", "jdbc:mysql://localhost/hibernate");
			props.put("hibernate.connection.username", "root");
			props.put("hibernate.connection.password", "hjIt64-JkeUY");
			props.put("hibernate.current_session_context_class", "thread");
			
			configuration.setProperties(props);
			
			configuration.addAnnotatedClass(Employee.class);
			
			ServiceRegistry serviceRegistry = 
					new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties())
						.build();
	    	System.out.println("Hibernate Java Config serviceRegistry created");
	    	
	    	SessionFactory sessionFactory = 
	    			configuration.buildSessionFactory(serviceRegistry);
	    	
	        return sessionFactory;
    	}
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
	}
    	
	private static SessionFactory getSessionFactory() {
		try {
			return sessionFactory == null
				?sessionFactory = buildSessionFactory()
				:sessionFactory;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
	
    public static void closeSessionFactory() {
    	if(sessionFactory == null) {return;}
    	
    	sessionFactory.close();
    }
	
	
    private  Session currentSession;
    
    private  Transaction currentTransaction;
 
    public Session openCurrentSession() {
    	getSessionFactory();
    	if(sessionFactory == null) {return null;}
    	
        currentSession = sessionFactory.openSession();
        return currentSession;
    }
 
    public Session openCurrentSessionwithTransaction() {
    	getSessionFactory();
    	if(sessionFactory == null) {return null;}
    	
        currentSession = sessionFactory.openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
     
    public void closeCurrentSession() {
    	if(currentSession == null) {return;}
    	
        currentSession.close();
    }
     
    public void closeCurrentSessionwithTransaction() {
    	if(currentSession == null) {return;}
    	if(currentTransaction == null) {return;}
    	
        currentTransaction.commit();
        currentSession.close();
    }
    	
}
