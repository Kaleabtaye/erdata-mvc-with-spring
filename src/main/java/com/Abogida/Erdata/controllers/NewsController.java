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
import com.Abogida.Erdata.domains.News;
import com.Abogida.Erdata.security.Donor;
import com.Abogida.Erdata.services.NewsService;

@Controller
@RequestMapping("/news")
public class NewsController {
	
	private NewsService newsService;
	
	@Autowired
	public NewsController(NewsService newsService) {
		this.newsService = newsService;
	}
	
	@GetMapping
	public String newsPage() {
		return "news";
	}
	
	
	@PostMapping("/submitNews")
	public String submitNews(@Valid News news, BindingResult bindingResult, Model model,Errors errors) {
		if(errors.hasErrors()) {
			return "news";
		}
		if (bindingResult.hasErrors()) {
			return "news";
		} 
		else{
           newsService.save(news); 
           model.addAttribute("successMessage", "News has been successfully Posted");
           return "news";
		}
	}
	
	@ModelAttribute
	public void news(Model model) {
		model.addAttribute("news",new News());
	}
	@ModelAttribute(name="news")
	public News news() {
			return new News();
	}
}

