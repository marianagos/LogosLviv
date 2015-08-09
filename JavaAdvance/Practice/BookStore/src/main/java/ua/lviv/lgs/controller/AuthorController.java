package ua.lviv.lgs.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.lgs.domain.Author;
import ua.lviv.lgs.service.AuthorService;

@Controller
public class AuthorController {
	@Autowired
	private AuthorService service;

	@RequestMapping(value = "/test")
	public String test(Model model) {
		Author a = new Author();
		a.setBirthday(new Date());
		a.setDescription("This is simple description");
		a.setEmail("melnychuk.bogdan@gmail.com");
		a.setName("Bogdan Melnychuk");

		service.create(a);

		List<Author> authors = service.findAll();

		System.out.println(authors);
		System.out.println(service.count());

		return "authors";
	}

	@RequestMapping(value = "/showAll")
	public String getAllAuthors(Model model) {
		List<Author> authors = service.findAll();
		model.addAttribute("authors", authors);
		return "authors";
	}

	@RequestMapping(value = "/createAuthor")
	public String createPage() {
		return "newAuthor";
	}

	@RequestMapping(value = "/showAll", method = RequestMethod.POST)
	public String creatingAuthor(Model model,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "age") int age) {
		Author a = new Author();
		service.create(a);
		return "redirect:/showAll";
	}
}
