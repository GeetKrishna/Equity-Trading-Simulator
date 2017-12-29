package com.bababroker.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bababroker.model.Execution;

@Repository
public class ExecutionDAOImpl extends GenericDAOImpl<Execution, Long> implements
		ExecutionDAO{

	
	public ExecutionDAOImpl() {
		super(Execution.class);
		// TODO Auto-generated constructor stub
	}
	@Transactional
	public void saveE(Execution execution) {
		// TODO Auto-generated method stub
		super.save(execution);
	}
	@Transactional
	public void updateE(Execution execution) {
		// TODO Auto-generated method stub
		super.update(execution);
	}
	@Transactional
	public Execution findByIdE(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}
	@Transactional
	public List<Execution> findAllE() {
		// TODO Auto-generated method stub
		return super.findAll();
	}
	@Transactional
	public void deleteE(Execution execution) {
		// TODO Auto-generated method stub
		super.delete(execution);
	}

}
