package com.abogiida.erdata.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abogiida.erdata.security.Donor;
import com.abogiida.erdata.services.DonorService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
    private DonorService userService;
	
    @GetMapping
    public String login(){
        return "login";
    }

   
    @GetMapping("/access-denied")
    public String accessDenied(){
        return "access_denied";
    } 
	/*@PostMapping
	private String Authenticate(@Valid Donor user,Errors errors) {
		if(errors.hasErrors()) {
			return "login";
		}
		Donor checkUser = userService.findUserByUsername(user.getUsername());
		if(checkUser != null) {
			return "redirect:/index";
		}
		return "login";
	}
*/
	@ModelAttribute(name="user")
	public Donor user() {
		return new Donor();
	}

	@ModelAttribute
	public void user(Model model) {
		model.addAttribute("user",new Donor());
	}
}
