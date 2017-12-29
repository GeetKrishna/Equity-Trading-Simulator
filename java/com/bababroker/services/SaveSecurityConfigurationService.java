package com.bababroker.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bababroker.dao.ConfigurationInfoDAO;
import com.bababroker.dao.SecurityConfigMappingDAO;
import com.bababroker.dao.SecurityDAO;
import com.bababroker.model.ConfigurationInfo;
import com.bababroker.model.Security;
import com.bababroker.model.SecurityConfigMapping;

@Component
public class SaveSecurityConfigurationService {
	
	@Autowired
	ConfigurationInfoDAO configurationinfodao;
	
	@Autowired
	SecurityDAO securitydao;
	
	@Autowired
	SecurityConfigMappingDAO securityconfigmappingdao;

	public StringBuffer saveConfiguration(String maxPriceSpread, String maxNumExecutions,
			String maxTimeBtwExecutions, String probPercentFullExec,
			 String selectedSecurities){
		
		StringBuffer errors = new StringBuffer();
		//errors.append("Errors Saving Config:<br>");
		boolean fieldIsNull = false;
		if (maxPriceSpread == null){
			fieldIsNull=true;
			errors.append("-Please fill in data for Max Price Spread<br>");
		}
		if (maxNumExecutions == null){
			fieldIsNull=true;
			errors.append("-Please fill in data for Max Number of Executions<br>");
		}
		if (maxTimeBtwExecutions == null){
			fieldIsNull=true;
			errors.append("-Please fill in data for Max Interval between Executions<br>");
		}
		if (probPercentFullExec == null){
			fieldIsNull=true;
			errors.append("-Please fill in data for Probable Percentage of Fully Executed Orders<br>");
		}

		boolean fieldIsIncorrect = false;
		if (maxPriceSpread != null){
			try{
				BigDecimal bd = new BigDecimal(maxPriceSpread);
				if (bd.intValue() <= 0 || bd.intValue() >=100){
					fieldIsIncorrect=true;
					errors.append("-Max Price Spread must be an integer between 0-100<br>");
				}
			}
			catch(Exception e){
				fieldIsIncorrect=true;
				errors.append("-Max Price Spread must be an integer between 0-100<br>");
			}

		}
		if (maxNumExecutions != null){
			try{
				BigDecimal bd = new BigDecimal(maxNumExecutions);
				if (bd.intValue() <= 0){
					fieldIsIncorrect=true;
					errors.append("-Max Number of Executions must be a positive integer<br>");
				}
			}
			catch(Exception e){
				fieldIsIncorrect=true;
				errors.append("-Max Number of Executions must be a positive integer<br>");
			}

		}
		if (maxTimeBtwExecutions != null){
			try{
				BigDecimal bd = new BigDecimal(maxTimeBtwExecutions);
				if (bd.intValue() <= 0){
					fieldIsIncorrect=true;
					errors.append("-Max Interval between Executions must be a positive integer<br>");
				}
			}
			catch(Exception e){
				fieldIsIncorrect=true;
				errors.append("-Max Interval between Executions must be a positive integer<br>");
			}

		}
		if (probPercentFullExec != null){
			try{
				BigDecimal bd = new BigDecimal(probPercentFullExec);
				if (bd.intValue() <= 0 || bd.intValue() >=100){
					fieldIsIncorrect=true;
					errors.append("-Probable Percentage of Fully Executed Orders "
							+ "must be an integer between 0-100<br>");
				}
			}
			catch(Exception e){
				fieldIsIncorrect=true;
				errors.append("-Probable Percentage of Fully Executed Orders "
						+ "must be an integer between 0-100<br>");
			}

		}
		
		boolean securityNotSelected = false;
		if (selectedSecurities == null){
			securityNotSelected=true;
			errors.append("-No securities selected<br>");
		}
		
		if (fieldIsNull || fieldIsIncorrect || securityNotSelected){
			return errors;
		}
		
		StringBuffer resultString = new StringBuffer();
		
		
		
		
		ConfigurationInfo c = new ConfigurationInfo();
		c.setMaxpricespread(new BigDecimal(maxPriceSpread));
		c.setMaxnumexecutions(new BigDecimal(maxNumExecutions));
		c.setMaxtimebtwexecutions(new BigDecimal(maxTimeBtwExecutions));
		c.setProbpercentfullexec(new BigDecimal(probPercentFullExec));



		configurationinfodao.saveC(c);
		
		ConfigurationInfo c1 = configurationinfodao.findConfigByFields(new BigDecimal(maxPriceSpread)
		, new BigDecimal(maxNumExecutions), new BigDecimal(maxTimeBtwExecutions)
		, new BigDecimal(probPercentFullExec));
		
		String[] securities = selectedSecurities.split(",");
		for(String st : securities){
			SecurityConfigMapping scm = new SecurityConfigMapping();
			String symbol = st.split(" ")[0];
			Security security = securitydao.findByIdS(symbol);
			try{
				//scm.setSecurity(securityDao.findById(symbol));
				scm.setSecuritysymbol(security.getSecuritysymbol());
				scm.setSecurity(security);
				scm.setConfigurationInfo(c1);
				securityconfigmappingdao.saveSCM(scm);
//				Security sec = securityDao.findById(symbol);
//				scm = scDao.findById(symbol);
//				sec.setSecurityConfigMapping(scm);
//				securityDao.save(sec);
//				c.addSecurityConfigMapping(scm);
		
				//securityDao.save(security);
//				securityDao.findById(symbol).setSecurityConfigMapping(scm);
//				securityDao.save(securityDao.findById(symbol));
//				scDao.save(scm);
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		resultString.append("Security configuration saved");
		
		return resultString;
		
	}
	
}
