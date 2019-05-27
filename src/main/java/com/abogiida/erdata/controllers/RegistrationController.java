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
import com.abogiida.erdata.security.Reciever;
import com.abogiida.erdata.services.DonorService;
import com.abogiida.erdata.services.RecieverService;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
    private DonorService userService;
	private RecieverService recieverService;
	
	@Autowired
	public RegistrationController(DonorService userService,RecieverService recieverService) {
		this.userService = userService;
		this.recieverService = recieverService;
	}
	
	 @GetMapping
	 public String register(){
	        return "register";
	    }
	 @GetMapping("/recieverRegistration")
	 public String recieverRegister() {
		 return "recieverRegistration";
	 }
	 
	 @PostMapping
	 public String createNewUser(@Valid Donor user, BindingResult bindingResult, Model model,Errors errors) {
	    	if(errors.hasErrors()) {
				return "register";
			}
	        Donor userExists = userService.findUserByUsername(user.getUsername());
	        if (userExists != null) {
	           /* bindingResult
	                    .rejectValue("user", "error.user",
	                            "There is already a user registered with the username provided");*/
	        	model.addAttribute("userNameExists","There is already a user registered with the username provided");
	        }
	        if (bindingResult.hasErrors()) {
	            return "register";
	        } else {
	        	
	            userService.saveUser(user);
	            
	            model.addAttribute("successMessage", "Donor has been registered successfully");
	            
	            return "redirect:/index";
	        }
	    }
	 
	 @PostMapping("/recieverRegistration")
	 public String CreateNewReciever(@Valid Reciever reciever, BindingResult bindingResult, Model model,Errors errors) {
		 if(errors.hasErrors()) {
				return "recieverRegistration";
		}
	     Reciever recieverExists = recieverService.findUserByUsername(reciever.getUsername());
	     if (recieverExists != null) {
	          	model.addAttribute("userNameExists","There is already a user registered with the username provided");
	     }
	     if (bindingResult.hasErrors()) {
	            return "recieverRegistration";
	     } 
	     else {
	        	
	        	recieverService.saveUser(reciever);
	            
	            model.addAttribute("successMessage", "Reciever has been registered successfully");
	            
	            return "redirect:/index";
	     }
		 
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
