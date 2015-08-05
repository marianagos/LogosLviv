package ua.lviv.lgs.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.lgs.dao.BookDao;
import ua.lviv.lgs.domain.Book;

@Repository
public class BookDaoImpl extends BaseDaoImpl<Book> implements BookDao{

	public BookDaoImpl() {
		super(Book.class);
		// TODO Auto-generated constructor stub
	}
	
}
