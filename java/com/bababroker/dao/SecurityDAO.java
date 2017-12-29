package com.bababroker.dao;

import java.util.List;

import com.bababroker.model.Block;
import com.bababroker.model.Security;

public interface SecurityDAO extends GenericDAO<Security, String> {
	
	void saveS(Security security);
	void updateS(Security security);
	Security findByIdS(String id);
	List<Security> findAllS();
	List<Security> findUnconfiguredSecurities();
	void deleteS(Security security);
	List<Security> findConfiguredSecurities();

}
