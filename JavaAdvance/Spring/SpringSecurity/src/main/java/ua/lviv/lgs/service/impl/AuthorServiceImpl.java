package ua.lviv.lgs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.AuthorDao;
import ua.lviv.lgs.dao.impl.AuthorDaoImpl;
import ua.lviv.lgs.domain.Author;
import ua.lviv.lgs.service.AuthorServce;

@Service("authorService")
public class AuthorServiceImpl implements AuthorServce{
	
	@Autowired
	private AuthorDao dao;

	public void insertAuthor(Author a) {
		dao.insert(a);
	}

	public Author findAuthor(int id) {
		return dao.findById(id);
	}

	public List<Author> getAuthors() {
		return dao.getAll();
	}
	
	

}
