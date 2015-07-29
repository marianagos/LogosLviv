package ua.lviv.lgs.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.AuthorDao;
import ua.lviv.lgs.dao.BookDao;
import ua.lviv.lgs.domain.Author;
import ua.lviv.lgs.domain.Book;
import ua.lviv.lgs.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
	@Autowired
	private AuthorDao dao;
	
	@Autowired
	private BookDao bookDao;

	@Transactional
	public void insertAuthor(Author author) {
		dao.create(author);
		Book b = new Book("Hello world");
		b.setAuthor(author);
		bookDao.create(b);
		//dao.insert(new Author("TTTTTTTTT", author.getAge() - 5));
	}

	public List<Author> getAllAuthors() {
		return dao.findAll();
	}

	public List<Author> getAuthorByName(String name) {
		return dao.getByName(name);
	}

}
