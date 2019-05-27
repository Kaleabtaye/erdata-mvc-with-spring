package com.abogiida.erdata.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abogiida.erdata.security.Donor;

@Controller
@RequestMapping("/index")
public class UserHomeController {
	@GetMapping
	public String index() {
		return "index";
	}
	@ModelAttribute
	public void order(Model model) {
		model.addAttribute("user",new Donor());
	}
}
