package com.abogiida.erdata.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abogiida.erdata.security.Donor;
import com.abogiida.erdata.security.Reciever;
import com.abogiida.erdata.security.User;
import com.abogiida.erdata.services.DonorService;
import com.abogiida.erdata.services.RecieverService;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	private RecieverService recieverService;
	private DonorService donorService;
	
	public ProfileController(RecieverService recieverService,DonorService donorService) {
		this.recieverService = recieverService;
		this.donorService = donorService;
	}
	@GetMapping
	public String profilePage() {
		return "profile";
	}
	
	@ModelAttribute
	public void retrieveUser(Model model) {
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     String name = auth.getName();
	     Reciever recieverProfile = recieverService.findUserByUsername(name);
	     model.addAttribute("recieverProfile",recieverProfile);
	     //model.addAttribute("username", name);	
	}
	@ModelAttribute(name="user")
	public User user() {
			return new User();
	}
	
	 @ModelAttribute
	 public void user(Model model) {
			model.addAttribute("user",new User());
	}
	@ModelAttribute(name="reciever")
	public Reciever reciever() {
			return new Reciever();
	}
	
	@ModelAttribute
	public void reciever(Model model) {
			model.addAttribute("reciever",new Reciever());
	}
	@ModelAttribute(name="donor")
	public Donor donor() {
			return new Donor();
	}
	
	@ModelAttribute
	public void donor(Model model) {
			model.addAttribute("donor",new Donor());
		}
	
	   
}
