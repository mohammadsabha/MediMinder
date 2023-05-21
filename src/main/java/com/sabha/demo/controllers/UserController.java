package com.sabha.demo.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sabha.demo.models.User;
import com.sabha.demo.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

//imports removed for brevity
@Controller
public class UserController {
	private UserService userService;
 
 public UserController(UserService userService) {
     this.userService = userService;
 }
 
 @RequestMapping("/register")
 public String registerForm(@Valid @ModelAttribute("user") User user) {
     return "registrationPage.jsp";
 }
 
 @PostMapping("/register")
 public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
     if (result.hasErrors()) {
         return "registrationPage.jsp";
     }
     userService.saveUserWithAdminRole(user);
     return "redirect:/login";
 }
 
 @RequestMapping("/login")
 public String login() {
     return "loginPage.jsp";
 }
 
}


