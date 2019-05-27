package com.abogiida.erdata.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abogiida.erdata.domains.Comment;
import com.abogiida.erdata.domains.FreeAid;
import com.abogiida.erdata.domains.Job;
import com.abogiida.erdata.security.Donor;
import com.abogiida.erdata.services.CommentService;

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
	public void addCommentsToModel(Model model) {
		List<Comment> comment = new ArrayList<>();
		commentService.findAll().forEach(i->comment.add(i));
		model.addAttribute("commentView",comment);
	}
	
	@ModelAttribute
	public void comment(Model model) {
		model.addAttribute("comment",new Comment());
	}
	@ModelAttribute(name="comment")
	public Comment comment() {
		return new Comment();
	}
	@ModelAttribute
	public void addRoleToModel(Model model) {
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     String name = auth.getName();
	      
	      
	}
	
}
