package com.bababroker.dao;

import java.util.List;
import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.bababroker.model.ConfigurationInfo;

@Component
public interface ConfigurationInfoDAO extends GenericDAO<ConfigurationInfo, Long> {

	void saveC(ConfigurationInfo config);
	void updateC(ConfigurationInfo config);
	ConfigurationInfo findByIdC(Long id);
	List<ConfigurationInfo> findAllC();
	void deleteC(ConfigurationInfo config);

	public ConfigurationInfo findConfigByFields(BigDecimal maxPriceSpread, BigDecimal maxNumExecutions,
			BigDecimal maxTimeBtwExecutions, BigDecimal probPercentFullExec);

}
