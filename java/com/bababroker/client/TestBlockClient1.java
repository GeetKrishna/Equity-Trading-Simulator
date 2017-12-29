package com.bababroker.client;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import com.bababroker.dao.BlockDAO;
import com.bababroker.dao.BlockDAOImpl;
import com.bababroker.dao.ConfigurationInfoDAO;
import com.bababroker.dao.ConfigurationInfoDAOImpl;
import com.bababroker.dao.SecurityDAO;
import com.bababroker.dao.SecurityDAOImpl;
import com.bababroker.model.Block;
import com.bababroker.model.ConfigurationInfo;
import com.bababroker.model.Execution;
import com.bababroker.model.Security;
import com.bababroker.model.SecurityConfigMapping;

public class TestBlockClient1 {
	public static void main(String[] args) {

//		BlockDAO<Block, Long> blockDAO = new BlockDAOImpl<Block, Long>(
//				JPATemplate.getEntityManager(), Block.class);
//
//		SecurityDAO<Security, String> securityDAO = new SecurityDAOImpl<Security, String>(
//				JPATemplate.getEntityManager(), Security.class);
//		// Security s1 = new Security("Goo", 100,"Google" , blocks,
//		// securityConfigMapping);
//
//		Block b2 = new Block(new BigDecimal(20), new BigDecimal(200), "SELL",
//				"Executed", new BigDecimal(120), new Timestamp(
//						new Date().getTime()), new Timestamp(
//						new Date().getTime()), new BigDecimal(50));
//		Security s1 = new Security();
//		s1 = securityDAO.findById("Goo");
//		b2.setSecurity(s1);
//		s1.addBlock(b2);
//		blockDAO.save(b2);
//		ConfigurationInfoDAO<ConfigurationInfo, Long> ConfigurationInfoDAO = new ConfigurationInfoDAOImpl<ConfigurationInfo, Long>(
//				JPATemplate.getEntityManager(), ConfigurationInfo.class);
//		BigDecimal maxNumberOfExecution =blockDAO.findById(1002L).getSecurity().getSecurityConfigMapping().getConfigurationInfo().getMaxnumexecutions();
//		System.out.println(maxNumberOfExecution);
		/*
		 * @SuppressWarnings("deprecation") Execution e1 = new Execution(new
		 * BigDecimal(120), new BigDecimal(20), new Timestamp( new
		 * Date().getDate()), b1); SecurityConfigMapping s1 = new
		 * SecurityConfigMapping(securitysymbol, datecreated, configurationInfo,
		 * security) ConfigurationInfo c1 = new ConfigurationInfo(new
		 * BigDecimal(2), new BigDecimal(20), new BigDecimal(20), new
		 * BigDecimal(20), securityConfigMappings) Security s1 = new
		 * Security("Goo", 100,"Google" , blocks, securityConfigMapping);
		 * b1.setSecurity()
		 */

	}
}