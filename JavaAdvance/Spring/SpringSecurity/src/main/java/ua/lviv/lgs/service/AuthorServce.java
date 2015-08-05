package ua.lviv.lgs.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import ua.lviv.lgs.domain.Author;

public interface AuthorServce {
	void insertAuthor(Author a);
	
	Author findAuthor(int id);
	
	List<Author> getAuthors();
}
