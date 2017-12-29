package com.bababroker.controller;





import com.bababroker.dao.ExecutionDAO;
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
import com.bababroker.services.ViewFillsService;




@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserServices userServices;
	
	@Autowired
	private ViewFillsService viewfillsservice;
	
	@Autowired
	private ExecutionDAO executiondao;
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView handleLogin(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		
		 UserT user =new UserT();
		
		user.setUsername(username);
		user.setPassword(password);


		if(userServices.validateUser(user)){
			
			ModelAndView mv =new ModelAndView();
			mv.setViewName("viewfills");
			
		
			return mv;
			//return new ModelAndView("redirect:jsp/viewfills.jsp");
		}else{
		
			String message = "Invalid credentials, try again";
            return new ModelAndView("login","message",message);
		}
		
	}
	
	@ModelAttribute
	public Model handleView(Model model) {
		
		model.addAttribute("executions", viewfillsservice.viewFills());
		return model;

	}
	
	@ModelAttribute
	public Model executionCount(Model model){
		
		model.addAttribute("executionCount", viewfillsservice.viewFills().size());
		return model;
	}
	
	

}
