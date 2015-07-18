package ua.lviv.lgs.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ua.lviv.lgs.domain.Author;

public class AuthorDao {
	private SessionFactory factory;

	public void insertAuthor(Author author) {
		Session s = factory.openSession();
		s.beginTransaction();
		s.save(author);
		s.getTransaction().commit();
		s.close();
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
}
