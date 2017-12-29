package com.bababroker.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;





import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class GenericDAOImpl<T, ID extends java.io.Serializable> implements
		GenericDAO<T, ID> {

	@PersistenceContext
	@Autowired
	private EntityManager entityManager;
	
	private Class<T> persistenceClass = null;
	
	public GenericDAOImpl(Class<T> persistenceClass) {
		
		this.persistenceClass = persistenceClass;
	}

	public EntityManager getEm() {
		// TODO Auto-generated method stub
		return this.entityManager;
	}
	public Class<T> getpersistentClass(){
		return this.persistenceClass;
	}

	public T save(T entity) {
		
			entityManager.persist(entity);
		//entityManager.merge(entity);
			return entity;
	}

	public void update(T entity) {
		entityManager.merge(entity);
	}


	
	public List<T> findAll() {
		return entityManager.createQuery("select e from "+persistenceClass.getName()+" as e").getResultList();
	}

	public void delete(T entity) {
		entityManager.remove(entity);

	}

	public T findById(ID id) {
		// TODO Auto-generated method stub
		//this.persistenceClass=entity.getClass().getName();
		return (T) entityManager.find(persistenceClass, id);
	}

	
	

	

	

	
	

	
}
