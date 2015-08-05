package ua.lviv.lgs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.lgs.domain.Author;
import ua.lviv.lgs.service.AuthorServce;

@Controller
public class AuthorController {
	@Autowired
	private AuthorServce service;
	
	@RequestMapping(value = "/showAll")
	public String getAllAuthors(Model model) {
		List<Author> authors = service.getAuthors();
		model.addAttribute("authors", authors);
		return "author-all";
	}
	
	//@Secured({"Admin","ROLE_ADMIN"})
	@Secured("Admin")
	@RequestMapping(value = "/createAuthor")
	public String createPage() {
		return "author-new";
	}
	
	@RequestMapping(value = "/showAll", method=RequestMethod.POST)
	public String creatingAuthor(Model model, @RequestParam(value="name") String name,
			@RequestParam(value="age") String age) {
		int ageInt = Integer.parseInt(age);
		Author a = new Author(name, ageInt);
		service.insertAuthor(a);
		return "redirect:/showAll";
	}
	
	@RequestMapping(value = "/index")
	public String home() {
		return "home";
	}
}
