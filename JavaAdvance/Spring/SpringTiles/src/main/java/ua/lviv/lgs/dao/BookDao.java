package ua.lviv.lgs.dao;

import java.util.List;

import ua.lviv.lgs.domain.Author;
import ua.lviv.lgs.domain.Book;

public interface BookDao {
	void insert(Book book);
	
	List<Book> getAll();
	
	void delete (Book book);
	
	void deleteById (int id);
}
