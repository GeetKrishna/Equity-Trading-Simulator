package com.bababroker.dao;

import java.util.List;

import com.bababroker.model.Block;
import com.bababroker.model.SecurityConfigMapping;

public interface SecurityConfigMappingDAO extends GenericDAO<SecurityConfigMapping, String> {

	void saveSCM(SecurityConfigMapping scm);
	void updateSCM(SecurityConfigMapping scm);
	SecurityConfigMapping findByIdSCM(String id);
	List<SecurityConfigMapping> findAllSCM();
	void deleteSCM(SecurityConfigMapping scm);
}
