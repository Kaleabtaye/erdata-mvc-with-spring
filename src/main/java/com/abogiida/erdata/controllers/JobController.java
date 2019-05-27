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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abogiida.erdata.domains.Job;
import com.abogiida.erdata.security.Donor;
import com.abogiida.erdata.services.DonorService;
import com.abogiida.erdata.services.JobService;
@Controller
@RequestMapping
public class JobController {
	@Autowired
    private JobService jobService;
	
	public JobController(JobService jobService) {
		this.jobService = jobService;
	}  
	@ModelAttribute
	public void job(Model model) {
		model.addAttribute("job",new Job());
	}
	@ModelAttribute
	public void addJobsToModel(Model model) {
		List<Job> jobs = new ArrayList<>();
		jobService.findAll().forEach(i->jobs.add(i));
		/*for(Job job : jobs) {
			model.addAttribute("jobView",job);
		}*/
		model.addAttribute("jobView",jobs);
		
	}
	@GetMapping("/job")
	public String jobs() {
		return "job";
	}
	@GetMapping("/jobView")
	public String jobView() {
		return "jobView";
	}
	
	@PostMapping("/job")
	public String postJob(@Valid Job job, BindingResult bindingResult, Model model,Errors errors) {
		if(errors.hasErrors()) {
			return "job";
		}
		if (bindingResult.hasErrors()) {
	         return "job";
	    } 
		else{
	            jobService.save(job); 
	            model.addAttribute("successMessage", "Job has been successfully uploaded");
	            return "redirect:/job";
	    }
		
	}
}
