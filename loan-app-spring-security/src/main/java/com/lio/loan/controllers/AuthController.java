package com.lio.loan.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {
	
	@RequestMapping("/login")
	public String userLogin(){
		
		return "secure/login";
	}

}
