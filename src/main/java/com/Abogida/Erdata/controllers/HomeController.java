package com.Abogida.Erdata.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Abogida.Erdata.security.Donor;;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping
	public String home() {
		return "home";
	}  	
	
	@ModelAttribute
	public void order(Model model) {
		model.addAttribute("user",new Donor());
	}
}
