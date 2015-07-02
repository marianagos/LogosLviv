package ua.lviv.lgs;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class AuthorDao {
	public List<Author> findAll() {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			List<Author> authors = session.createCriteria(Author.class).list();
			return authors;
		} finally {
			closeSession(session);
		}
	}

	public Author findById(int id) {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			Author author = (Author) session.get(Author.class, id);
			return author;
		} finally {
			closeSession(session);
		}
	}

	public void create(Author author) {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			session.save(author);
			transaction.commit();
		} finally {
			closeSession(session);
		}
	}

	public List<Author> findByName(String name) {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			Query query = session.createSQLQuery("select * from Author s where s.firstName = :paramName").addEntity(Author.class)
					.setParameter("paramName", name);
			List<Author> result = query.list();
			return result;
		} finally {
			closeSession(session);
		}
	}

	public List<Author> findByLastName(String lastName) {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();

			Criteria cr = session.createCriteria(Author.class);
			cr.add(Restrictions.eq("lastName", lastName));
			List<Author> result = cr.list();
			return result;
		} finally {
			closeSession(session);
		}
	}

	private void closeSession(Session session) {
		if ((session != null) && (session.isOpen())) {
			session.close();
		}
	}
}
