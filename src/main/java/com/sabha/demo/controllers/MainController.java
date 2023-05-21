package com.sabha.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sabha.demo.models.User;
import com.sabha.demo.services.MainService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	
	@Autowired
	MainService mainService;
	
@RequestMapping("/")
public String showLoginPage(Model model) {
return "LoginTest.jsp";
}





@GetMapping("/user/new")
public String newClinic1(HttpSession session, Model model,@ModelAttribute("user") User user) {
	
 return "admin.jsp";
}

@PostMapping("/user/new")
public String newClinic2(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
    if (result.hasErrors()) {
        model.addAttribute("user", user);
        return "admin.jsp";
    } else {
        mainService.createUser(user);
        return "redirect:/user/new";
    }
}



}
