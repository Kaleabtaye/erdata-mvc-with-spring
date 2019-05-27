package com.Abogida.Erdata.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Abogida.Erdata.security.Donor;
import com.Abogida.Erdata.security.Reciever;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	@GetMapping
	public String profilePage() {
		return "profile";
	}
	@ModelAttribute(name="user")
	public Donor user() {
			return new Donor();
	}
	
	 @ModelAttribute
	 public void user(Model model) {
			model.addAttribute("user",new Donor());
		}
	 @ModelAttribute(name="reciever")
	 public Reciever reciever() {
			return new Reciever();
		}
	
	 @ModelAttribute
	 public void reciever(Model model) {
			model.addAttribute("reciever",new Reciever());
		}
	   
}
