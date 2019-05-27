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

import com.Abogida.Erdata.domains.Comment;
import com.Abogida.Erdata.domains.FreeAid;
import com.Abogida.Erdata.security.Donor;
import com.Abogida.Erdata.services.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	private CommentService commentService;
	
	@Autowired
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@GetMapping
	public String commentPage() {
		return "comment";
	}  	
	
	@PostMapping("/submitComment")
	public String submitComment(@Valid Comment comment, BindingResult bindingResult, Model model,Errors errors) {
		if(errors.hasErrors()) {
			return "comment";
		}
		if (bindingResult.hasErrors()) {
			return "comment";
		} 
		else{
           commentService.save(comment); 
           model.addAttribute("successMessage", "Comment has been successfully submitted");
           return "comment";
		}
	}
	
	
	@ModelAttribute
	public void comment(Model model) {
		model.addAttribute("comment",new Comment());
	}
	@ModelAttribute(name="comment")
	public Comment comment() {
			return new Comment();
	}
	
}
