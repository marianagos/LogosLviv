package ua.lviv.lgs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.lgs.domain.Author;
import ua.lviv.lgs.domain.Book;
import ua.lviv.lgs.service.AuthorService;
import ua.lviv.lgs.service.BookService;

@Controller
public class BookController {

	@Autowired
	private AuthorService aService;
	
	@Autowired
	private BookService bService;

	@RequestMapping(value = "/newBookForm")
	public String newBookForm(Model model) {
		List<Author> allAuthors = aService.getAllAuthors();
		model.addAttribute("authors", allAuthors);
		return "newBookPage";
	}

	@RequestMapping(value = "/newBook", method = RequestMethod.POST)
	public String createBook(Model model,
			@RequestParam(value = "title") String bookTitle,
			@RequestParam(value = "authorId") int aId) {
		Author a = aService.findById(aId);
		Book b = new Book("TEST_BOOK");
		b.setAuthor(a);
		bService.createBook(b);
		return "redirect:/newBookForm";
	}
}
