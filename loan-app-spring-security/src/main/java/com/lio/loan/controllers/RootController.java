package com.lio.loan.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {

	@RequestMapping(value="/")
	public String redirectHome(ModelMap model){
		model.addAttribute("userName", SecurityContextHolder.getContext().getAuthentication().getName());
		return "home";
		
	}
}
