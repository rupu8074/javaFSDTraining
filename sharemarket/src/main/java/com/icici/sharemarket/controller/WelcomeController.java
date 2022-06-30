package com.icici.sharemarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	
	@GetMapping(value="/showEmployeeRegistrationForm")
	public String employeeReg() {
		System.out.println("inside method");
		return "employeeRegistrationform";
	}

}
