package com.Abogida.Erdata.controllers;
import lombok.Data;
import java.awt.Image;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.Abogida.Erdata.domains.User;

@Controller
@RequestMapping("/register")
public class SignupHandler {
	public boolean verifyUserName(String userName) {

		return true;
	}
	@GetMapping("/signup")
	public String home() {
		return "register";
	} 
	@ModelAttribute
	public void user(Model model) {
		model.addAttribute("user",new User());
	}
	@PostMapping("/signup")
	public String register(@Valid User user,Errors errors) {
		if(errors.hasErrors()) {
			return "register";
		}
		return "redirect:/home";
	}
}
