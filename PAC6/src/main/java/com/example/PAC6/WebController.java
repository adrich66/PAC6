package com.example.PAC6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mylibrary")
public class WebController {
	
	@Autowired
	AuthorService authorService;

	
	
	  @RequestMapping("/home")
	  public String getWeb (Model containerToView) {
	  
	  containerToView.addAttribute("authorsfromController", authorService.queryAuthor());
	  System.out.println("Controller Web request ...");
	  
	  return "web"; }

}

