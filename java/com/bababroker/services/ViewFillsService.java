package com.bababroker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bababroker.dao.ExecutionDAO;
import com.bababroker.model.Execution;

@Component
public class ViewFillsService {
	
	@Autowired
	private ExecutionDAO executiondao;
	
	public List<Execution> viewFills(){
		return executiondao.findAllE();
	}

}
