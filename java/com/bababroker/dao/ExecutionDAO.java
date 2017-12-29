package com.bababroker.dao;

import java.util.List;

import com.bababroker.model.Execution;



public interface ExecutionDAO extends GenericDAO<Execution, Long> {

	void saveE(Execution execution);
	void updateE(Execution execution);
	Execution findByIdE(Long id);
	List<Execution> findAllE();
	void deleteE(Execution execution);
}
