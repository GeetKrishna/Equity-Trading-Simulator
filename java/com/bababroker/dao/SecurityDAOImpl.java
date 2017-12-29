package com.bababroker.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bababroker.model.Block;
import com.bababroker.model.Security;
@Repository
public class SecurityDAOImpl extends GenericDAOImpl<Security, String> implements SecurityDAO{

	public SecurityDAOImpl() {
		super(Security.class);
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public void saveS(Security security) {
		super.save(security);
		
	}

	@Transactional
	public void updateS(Security security) {
		super.update(security);
		
	}

	@Transactional
	public List<Security> findAllS() {

		Query query = this.getEm().createQuery("SELECT s FROM Security s ORDER BY s.securitysymbol");
		return (List<Security>) query.getResultList();

	}

	@Transactional
	public void deleteS(Security security) {
		super.delete(security);
		
	}
	@Transactional
	public Security findByIdS(String id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Transactional
	public List<Security> findUnconfiguredSecurities() {
		StringBuffer strQuery = new StringBuffer();
		strQuery.append("SELECT s FROM Security s ");
		strQuery.append("WHERE s.securitysymbol NOT IN ");
		strQuery.append("(SELECT m.securitysymbol FROM com.bababroker.model.SecurityConfigMapping m) ");
		strQuery.append("ORDER BY s.securitysymbol"); 
		Query query = this.getEm().createQuery(strQuery.toString());
		List<Security> securities = (List<Security>) query.getResultList();
		return securities;
	}

	@Transactional
	public List<Security> findConfiguredSecurities() {
		StringBuffer strQuery = new StringBuffer();
		strQuery.append("SELECT s FROM Security s ");
		strQuery.append("WHERE s.securitysymbol IN ");
		strQuery.append("(SELECT m.securitysymbol FROM com.bababroker.model.SecurityConfigMapping m) ");
		strQuery.append("ORDER BY s.securitysymbol"); 
		Query query = this.getEm().createQuery(strQuery.toString());
		List<Security> securities = (List<Security>) query.getResultList();
		return securities;
	}
}
