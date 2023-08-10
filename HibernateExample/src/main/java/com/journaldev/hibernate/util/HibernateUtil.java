package com.journaldev.hibernate.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.journaldev.hibernate.model.Employee;

public class HibernateUtil {

	private static SessionFactory sessionJavaConfigFactory;

    private static SessionFactory buildSessionJavaConfigFactory() {
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
    	
	public static SessionFactory getSessionJavaConfigFactory() {
		return sessionJavaConfigFactory == null
			?sessionJavaConfigFactory = buildSessionJavaConfigFactory()
			:sessionJavaConfigFactory;
    }
	
}
