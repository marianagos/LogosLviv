package ua.lviv.lgs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.lgs.dao.AuthorDao;
import ua.lviv.lgs.domain.Author;

@Controller
public class AuthorController {
	@Autowired
	private AuthorDao service;
	
	@RequestMapping(value = "/showAll")
	public String getAllAuthors(Model model) {
		List<Author> authors = service.getAll();
		model.addAttribute("authors", authors);
		return "authors";
		//return "author-all";
	}
	@RequestMapping(value = "/createAuthor")
	public String createPage() {
		return "newAuthor";
		//return "author-new";
	}

	@RequestMapping(value = "/showAll", method = RequestMethod.POST)
	public String creatingAuthor(Model model,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "age") String age) {
		int ageInt = Integer.parseInt(age);
		Author a = new Author(name, ageInt);
		service.insert(a);
		return "redirect:/showAll";
	}
}
