package com.sabha.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class MainController {
@RequestMapping("/")
public String showLoginPage(Model model) {
return "LoginTest.jsp";
}
}
