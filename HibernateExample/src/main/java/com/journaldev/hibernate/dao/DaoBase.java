package com.journaldev.hibernate.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.hibernate.Session;
import com.journaldev.hibernate.util.HibernateUtil;

public abstract class DaoBase<T, ID extends Serializable> {

	protected HibernateUtil hUtil;
	
	protected String tableName;
	
	private Class<T> persistentClass;
	
	public DaoBase(String tableName, Class<T> type) {
		hUtil = new HibernateUtil();
		this.tableName = tableName;
		this.persistentClass = type;
	}
	
	private void withTransaction(Consumer<Session> consumer) {
    	Session session = hUtil.openCurrentSessionwithTransaction();
    	if(session == null) {return;}
    	
    	consumer.accept(session);
    	
        hUtil.closeCurrentSessionwithTransaction();
	}
	
    public void persist(T entity) {
    	withTransaction(s -> s.save(entity));
    }
 
    public void update(T entity) {
    	withTransaction(s -> s.update(entity));
    }
    
    public void delete(ID id) {   
    	T entity = findById(id);
    	if(entity == null) {return;}	
    	
    	withTransaction(s -> s.delete(entity));	
    }
    
	private List<T> withOutTransaction(Function<Session, List<T>> func) {
    	Session session = hUtil.openCurrentSession();
    	if(session == null) {return new ArrayList<T>();}
    	if(persistentClass == null) {return new ArrayList<T>();}
    	
    	List<T> resList = func.apply(session);
    	
        hUtil.closeCurrentSession();
        
        return resList;
	}
 
    @SuppressWarnings("unchecked")
	public T findById(ID id) {
    	
    	List<T> resList = withOutTransaction(s -> {
    		T emp = (T) s.get(persistentClass, (Serializable) id);
    		
    		return emp != null
    				? Arrays.asList(emp)
					: new ArrayList<T>();
    	}); 
    			
        return resList.size() > 0 ? resList.get(0) : null;
    }
 
    @SuppressWarnings("unchecked")
	public List<T> findAll() {
    	return withOutTransaction(s -> 
    		(List<T>) s.createQuery("from " + tableName).list()); 
    }
}
