package ua.lviv.lgs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.BookDao;
import ua.lviv.lgs.domain.Book;
import ua.lviv.lgs.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService{
	@Autowired
	private BookDao dao;

	public void insertBook(Book book) {
		dao.insert(book);
		
	}

	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	public void delete(Book book) {
		// TODO Auto-generated method stub
		dao.delete(book);
		
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}
}
