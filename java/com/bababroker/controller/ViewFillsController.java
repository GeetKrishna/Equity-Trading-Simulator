package com.bababroker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bababroker.model.Execution;
import com.bababroker.services.ViewFillsService;

@Controller
@RequestMapping("/viewfills")
public class ViewFillsController {
	

	@Autowired
	private ViewFillsService viewfillsservice;
	
	@RequestMapping(value="viewfills1")
	public ModelAndView handleViewFillsPage() {
		
		List<Execution> executions = viewfillsservice.viewFills();
		ModelAndView mv =new ModelAndView("viewfills", "executions", executions);
		mv.addObject("executionCount", executions.size());
        return  mv;
		
	}
	
}
