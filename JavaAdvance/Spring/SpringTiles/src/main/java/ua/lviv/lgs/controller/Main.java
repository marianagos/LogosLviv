package ua.lviv.lgs.controller;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.lviv.lgs.domain.Author;
import ua.lviv.lgs.domain.Book;
import ua.lviv.lgs.service.AuthorService;
import ua.lviv.lgs.service.BookService;

public class Main {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"appContext.xml");
		AuthorService service = (AuthorService) context
				.getBean("authorService");
//		service.insertAuthor(new Author("Bulgakov", 363));
//		System.out.println(service.getAllAuthors());
//		System.out.println(service.getAuthorByName("Tolkin"));
		BookService bService = (BookService) context.getBean("bookService");
		Book b = new Book("Master");
//		System.out.println(service.getAuthorByName("Bulgakov").get(0));
		b.setAuthor(service.getAuthorByName("Bulgakov").get(0));
		bService.insertBook(b);
		context.close();
	}

}
