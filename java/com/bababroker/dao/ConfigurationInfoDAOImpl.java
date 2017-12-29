package com.bababroker.dao;

import java.util.List;
import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bababroker.model.Block;
import com.bababroker.model.ConfigurationInfo;

@Repository
public class ConfigurationInfoDAOImpl extends
		GenericDAOImpl<ConfigurationInfo, Long> implements ConfigurationInfoDAO {
	public ConfigurationInfoDAOImpl() {
		super(ConfigurationInfo.class);
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public void saveC(ConfigurationInfo config) {
		super.save(config);

	}

	@Transactional
	public void updateC(ConfigurationInfo config) {
		super.update(config);

	}

	@Transactional
	public List<ConfigurationInfo> findAllC() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Transactional
	public void deleteC(ConfigurationInfo config) {
		super.delete(config);

	}

	@Transactional
	public ConfigurationInfo findByIdC( Long id) {
		// TODO Auto-generated method stub
		return super.findById( id);
	}

	public ConfigurationInfo findConfigByFields(BigDecimal maxPriceSpread,
			BigDecimal maxNumExecutions, BigDecimal maxTimeBtwExecutions,
			BigDecimal probPercentFullExec) {
		Query query = this.getEm().createQuery(
				"SELECT c FROM ConfigurationInfo"
						+ " c WHERE c.maxpricespread = "
						+ maxPriceSpread.intValue() + " AND "
						+ "c.maxnumexecutions = " + maxNumExecutions.intValue()
						+ " AND " + "c.maxtimebtwexecutions = "
						+ maxTimeBtwExecutions.intValue() + " AND "
						+ "c.probpercentfullexec = "
						+ probPercentFullExec.intValue() + " ");
		List<ConfigurationInfo> configs = (List<ConfigurationInfo>)query.getResultList();
		if (configs!=null && !(configs.isEmpty())){return configs.get(0);}
		return null;
	}

	

}
