package com.abogiida.erdata.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.abogiida.erdata.domains.FreeAid;
import com.abogiida.erdata.security.Donor;
import com.abogiida.erdata.security.Reciever;
import com.abogiida.erdata.security.User;
import com.abogiida.erdata.services.RecieverService;

import java.util.Optional;

import com.abogiida.erdata.services.FreeAidService;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;

@Controller
@RequestMapping("/freeAid")
public class FreeAidController {
	
	private RecieverService recieverService;
	private FreeAidService freeAidService;
	
	@Autowired
	public FreeAidController(RecieverService recieverService,FreeAidService freeAidService) {
		this.recieverService = recieverService;
		this.freeAidService = freeAidService;
	}
	
	@ModelAttribute
	public void populateUsers(Model model) {
		List<Reciever> reciever = new ArrayList<>();
		recieverService.findAll().forEach(i -> reciever.add(i));
		model.addAttribute("recievers",reciever);
		
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
	
	@PostMapping("/donatePage")
	public String donateFreeAid(@Valid FreeAid freeAid, BindingResult bindingResult, Model model,Errors errors,Reciever reciever) {
		if(errors.hasErrors()) {
				return "freeAid";
		}
		if (bindingResult.hasErrors()) {
	         return "freeAid";
	    } 
		else{
	           freeAidService.save(freeAid); 
	           model.addAttribute("successMessage", "you have successfully posted a donation");
	           //reciever.recieveFreeAid(freeAid); 
	           return "freeAid";
	    }
	}
	@GetMapping("/recieverFreeAid")
	public String recieverFreeAid() {
		return "recieverFreeAid";
	}
	
	@GetMapping("/donatePage{id}")
	public String donatePage(@PathVariable @RequestParam(name = "id",defaultValue = "1")Long id,Model model) {
		Optional<Reciever> reciever = recieverService.findById(id);
		
		model.addAttribute("donationReciever",reciever.get());
		return "donatePage";
	}
/*	@PostMapping("/donatePage")
	public String handleDonation(@Valid FreeAid freeAid, BindingResult bindingResult, Model model,Errors errors,Reciever reciever) {
		
		reciever.recieveFreeAid(freeAid);
		return "redirect:/freeAid/donatePage";
	}
	*/
	@ModelAttribute
	public void freeAid(Model model) {
		model.addAttribute("aidType",FreeAid.AidType.values());
		model.addAttribute("freeAid",new FreeAid());
	}
	@ModelAttribute(name="reciever")
	public Reciever reciever() {
			return new Reciever();
	}
	@ModelAttribute(name="user")
	public FreeAid freeAid() {
			return new FreeAid();
	}
}
