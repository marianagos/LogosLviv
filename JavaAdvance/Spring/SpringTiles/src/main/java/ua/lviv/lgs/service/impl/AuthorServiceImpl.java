package ua.lviv.lgs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.AuthorDao;
import ua.lviv.lgs.domain.Author;
import ua.lviv.lgs.service.AuthorService;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService{
	@Autowired
	private AuthorDao dao;
	
	public void insertAuthor(Author author) {
		dao.insert(author);
	}

	public List<Author> getAllAuthors() {
		
		return dao.getAll();
	}

	public List<Author> getAuthorByName(String name) {
		// TODO Auto-generated method stub
		return dao.getByName(name);
	}

}
