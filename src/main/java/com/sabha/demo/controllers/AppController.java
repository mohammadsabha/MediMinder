package com.sabha.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	
	@GetMapping("/admin")
	public String admin() {
		return "admin.jsp";
	}
}
