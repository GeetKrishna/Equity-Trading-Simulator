package com.bababroker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bababroker.dao.ExecutionDAO;
import com.bababroker.model.Execution;
import com.bababroker.services.ExchangeScheduler;
import com.bababroker.services.ViewFillsService;

@Controller
@RequestMapping("/execute")
public class ExecuteBlockController {
	@Autowired
	private ExecutionDAO executiondao;
	@Autowired
	private ViewFillsService viewfillsservice;
	@Autowired
	private ExchangeScheduler exchangeScheduler;
	@RequestMapping("/startexecution")
	public ModelAndView startExecution(){
//		System.out.println("in executer controller");
		//exchangeServices.startExchange();
		exchangeScheduler.startExchange();
		//executionServices.startExecution();
		List<Execution> executions = viewfillsservice.viewFills();
		ModelAndView mv =new ModelAndView("viewfills", "executions", executions);
		mv.addObject("executionCount", executions.size());
		mv.addObject("exchangeIsRunning", 1);
        return  mv;
		
	}
}
