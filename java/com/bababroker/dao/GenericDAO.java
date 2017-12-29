package com.bababroker.dao;

import java.util.List;

import javax.persistence.EntityManager;

public interface GenericDAO<T, ID extends java.io.Serializable> {

	public T findById(ID id);
	List<T> findAll();
	public T save(T entity);
	void delete(final T entity);
	public void update(T entity);
	public EntityManager getEm();
	
}
