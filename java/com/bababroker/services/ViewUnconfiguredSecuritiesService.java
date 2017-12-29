package com.bababroker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bababroker.dao.ExecutionDAO;
import com.bababroker.dao.SecurityDAO;
import com.bababroker.model.Execution;
import com.bababroker.model.Security;

@Component
public class ViewUnconfiguredSecuritiesService {
	
	@Autowired
	private SecurityDAO securitydao;
	
	public List<Security> viewUnconfiguredSecurities(){
		return securitydao.findUnconfiguredSecurities();
	}

}
