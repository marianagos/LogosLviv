package ua.lviv.lgs.service;

import java.util.List;

import ua.lviv.lgs.domain.Book;

public interface BookService {
	void insertBook(Book book);

	List<Book> getAllBooks();

	void delete(Book book);

	void deleteById(int id);
}
