package ua.lviv.lgs.service;

import java.util.List;

import ua.lviv.lgs.domain.Book;

public interface BookService {
	void insertBook(Book b);

	Book findBook(int id);
	
	List<Book> getAllBooks();
}
