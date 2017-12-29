package com.bababroker.controller;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bababroker.dao.BlockDAO;
import com.bababroker.dao.BlockDAOImpl;
import com.bababroker.dao.ExecutionDAO;
import com.bababroker.dao.ExecutionDAOImpl;
import com.bababroker.dao.SecurityDAO;
import com.bababroker.dao.SecurityDAOImpl;
import com.bababroker.model.Block;
import com.bababroker.model.Execution;
import com.bababroker.model.Security;
import com.bababroker.model.UserT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;










import com.bababroker.services.UserServices;
import com.bababroker.services.ViewConfiguredSecuritiesService;
import com.bababroker.services.ViewUnconfiguredSecuritiesService;




@Controller
@RequestMapping("/config")
public class ConfigureSecuritiesController {

	@Autowired
	private ViewUnconfiguredSecuritiesService viewUnconfiguredSecuritiesService;

	@Autowired
	private ViewConfiguredSecuritiesService viewConfiguredSecuritiesService;
	
	@RequestMapping(value="config1")
	public ModelAndView handleConfigPage() {		

		List<Security> mappedSecurities = viewConfiguredSecuritiesService.viewConfiguredSecurities();
		
		ModelAndView mv =new ModelAndView("ConfigureSecurities");
		mv.addObject("unmappedSecurities", 
				viewUnconfiguredSecuritiesService.viewUnconfiguredSecurities());
		mv.addObject("mappedSecurities", mappedSecurities);
		mv.addObject("mappedSecuritiesCount", mappedSecurities.size());
		
            return  mv;
		
	}
	
}
