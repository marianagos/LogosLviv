package ua.lviv.lgs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.lgs.dao.AuthorDao;
import ua.lviv.lgs.domain.Author;
import ua.lviv.lgs.service.AuthorService;

@Controller
public class AuthorController {
	@Autowired
	private AuthorService service;
		
	@RequestMapping(value = "/showAll")
	public String getAllAuthors(Model model) {
		List<Author> authors = service.getAllAuthors();
		model.addAttribute("authors", authors);
		return "authors";
	}
	
	@RequestMapping(value = "/youngAuthors")
	public String getAllYoungAuthors(Model model) {
		List<Author> authors = service.getAllAuthors();
		
		List<Author> youngOnes = new ArrayList<Author>();
		for(Author a : authors) {
			if(a.getAge() < 50) {
				youngOnes.add(a);
			}
		}
		
		model.addAttribute("authors", youngOnes);
		return "authors";
	}
	
	
	@RequestMapping(value = "/createAuthor")
	public String createPage() {
		return "newAuthor";
	}

	
	// locajjoef:8080/SpringMVC/showAll?name=Namfew&age=4
	@RequestMapping(value = "/showAll", method = RequestMethod.GET)
	public String creatingAuthor(Model model,
			@RequestParam(value = "name", required = false, defaultValue = Integer.MIN_VALUE) String name,
			@RequestParam(value = "age") int age) {
		Author a = new Author(name, age);
		service.insertAuthor(a);
		return "redirect:/showAll";
	}
}
