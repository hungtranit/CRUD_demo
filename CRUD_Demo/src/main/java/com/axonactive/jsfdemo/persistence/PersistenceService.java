package com.axonactive.jsfdemo.persistence;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

public interface PersistenceService<T> {
	
	T save(T entity);
	
	T update(T update);
	
	void removeEntity(T entity);
	
	void remove(Integer id);
	
	T findById(Integer id);

	Query createQuery(String query);
	
	TypedQuery<T> createNamedQuery(String query);
	
	

	void setPersistenceClass(Class<T> persistenceClass);
	
}
