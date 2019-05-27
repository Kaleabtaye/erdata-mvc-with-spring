package com.Abogida.Erdata.controllers;

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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;

import com.Abogida.Erdata.domains.FreeAid;
import com.Abogida.Erdata.security.Donor;
import com.Abogida.Erdata.security.Reciever;
import com.Abogida.Erdata.services.FreeAidService;
import com.Abogida.Erdata.security.User;

@Controller
@RequestMapping("/freeAid")
public class FreeAidController {
	
	private FreeAidService freeAidService;
	
	@Autowired
	public FreeAidController(FreeAidService freeAidService) {
		this.freeAidService = freeAidService;
	}
	
	
	@GetMapping
	public String freeAidPage() {
		return "freeAid";
	}
	@ModelAttribute
	public void printUser(Model model) {
		 
	      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName(); 
	      model.addAttribute("username", name);	 
	  }
	
	@PostMapping("/donateFreeAid")
	public String donateFreeAid(@Valid FreeAid freeAid, BindingResult bindingResult, Model model,Errors errors) {
		if(errors.hasErrors()) {
				return "freeAid";
		}
		if (bindingResult.hasErrors()) {
	         return "freeAid";
	    } 
		else{
	           freeAidService.save(freeAid); 
	            model.addAttribute("successMessage", "you have successfully posted a donation");
	            return "freeAid";
	    }
	}
	
	@ModelAttribute
	public void freeAid(Model model) {
		model.addAttribute("aidType",FreeAid.AidType.values());
		model.addAttribute("freeAid",new FreeAid());
	}
	 @ModelAttribute(name="user")
	 public FreeAid freeAid() {
			return new FreeAid();
	}
}
