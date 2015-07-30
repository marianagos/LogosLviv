package ua.lviv.lgs.dao;

import java.util.List;

import ua.lviv.lgs.domain.Author;

public interface AuthorDao {
	void insert(Author author);
	
	List<Author> getAll();
	
	List<Author> getByName(String name);
}
