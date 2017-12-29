package com.bababroker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/logout")
public class LogoutController {

	@RequestMapping(value="logout1")
	public ModelAndView handleLogout(){
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
}
