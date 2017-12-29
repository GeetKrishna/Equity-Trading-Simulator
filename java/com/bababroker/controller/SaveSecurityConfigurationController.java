package com.bababroker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bababroker.dao.SecurityDAO;
import com.bababroker.model.Security;
import com.bababroker.services.SaveSecurityConfigurationService;
import com.bababroker.services.ViewConfiguredSecuritiesService;
import com.bababroker.services.ViewUnconfiguredSecuritiesService;

@Controller
@RequestMapping("/saveConfig")
public class SaveSecurityConfigurationController {

	@Autowired
	private ViewUnconfiguredSecuritiesService viewUnconfiguredSecuritiesService;

	@Autowired
	private ViewConfiguredSecuritiesService viewConfiguredSecuritiesService;
	
	@Autowired
	private SaveSecurityConfigurationService service;

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView saveConfiguration(@RequestParam(value="maxpricespread", required=false) String maxPriceSpread,

			@RequestParam(value="maxnumexecutions", required=false) String maxNumExecutions,
			@RequestParam(value="maxtimebtwexecutions", required=false) String maxTimeBtwExecutions,
			@RequestParam(value="probpercentfullexec", required=false) String probPercentFullExec,
			@RequestParam(value="multiselect", required=false) String selectedSecurities) {

		
		StringBuffer resultStr = service.saveConfiguration(maxPriceSpread,
				maxNumExecutions, maxTimeBtwExecutions, probPercentFullExec, selectedSecurities);
		
		List<Security> mappedSecurities = viewConfiguredSecuritiesService.viewConfiguredSecurities();
		
		ModelAndView mv =new ModelAndView("ConfigureSecurities");
		mv.addObject("unmappedSecurities", 
				viewUnconfiguredSecuritiesService.viewUnconfiguredSecurities());
		mv.addObject("mappedSecurities", mappedSecurities);
		mv.addObject("mappedSecuritiesCount", mappedSecurities.size());

		if (!(resultStr.toString().equals("Security configuration saved"))){
			System.out.println(resultStr.toString());
			mv.addObject("error", resultStr.toString());
			return mv;
		}
		
		mv.addObject("saveMessage", resultStr.toString() + "<br>");	
		return mv;		
	}
	

}
