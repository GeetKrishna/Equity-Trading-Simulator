package com.bababroker.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bababroker.model.Block;
import com.bababroker.model.SecurityConfigMapping;

@Repository
public class SecurityConfigMappingDAOImpl extends
		GenericDAOImpl<SecurityConfigMapping, String> implements
		SecurityConfigMappingDAO {

	public SecurityConfigMappingDAOImpl() {
		super(SecurityConfigMapping.class);
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public void saveSCM(SecurityConfigMapping scm) {
		super.save(scm);

	}

	@Transactional
	public void updateSCM(SecurityConfigMapping scm) {
		super.update(scm);

	}

	@Transactional
	public List<SecurityConfigMapping> findAllSCM() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Transactional
	public void deleteSCM(SecurityConfigMapping scm) {
		super.delete(scm);

	}

	@Transactional
	public SecurityConfigMapping findByIdSCM( String id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

}
