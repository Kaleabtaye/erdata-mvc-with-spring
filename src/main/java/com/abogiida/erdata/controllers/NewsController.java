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

import com.abogiida.erdata.domains.Comment;
import com.abogiida.erdata.domains.FreeAid;
import com.abogiida.erdata.domains.Job;
import com.abogiida.erdata.domains.News;
import com.abogiida.erdata.security.Donor;
import com.abogiida.erdata.services.NewsService;

@Controller
@RequestMapping
public class NewsController {
	
	private NewsService newsService;
	
	@Autowired
	public NewsController(NewsService newsService) {
		this.newsService = newsService;
	}
	
	@GetMapping("/news")
	public String newsPage() {
		return "news";
	}
	@GetMapping("/newsView")
	public String newsViewPage() {
		return "newsView";
	}
	
	
	@PostMapping("news/submitNews")
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
	@ModelAttribute
	public void addNewsToModel(Model model) {
		List<News> news = new ArrayList<>();
		newsService.findAll().forEach(i->news.add(i));
		model.addAttribute("newsView",news);
	}
	
	
}

