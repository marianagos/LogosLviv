package ua.lviv.lgs.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ua.lviv.lgs.dao.BookDao;
import ua.lviv.lgs.domain.Author;
import ua.lviv.lgs.domain.Book;
@Repository
public class BookDaoImpl implements BookDao{
	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Transactional
	public void insert(Book book) {
		em.merge(book);
	}

	@Transactional
	public List<Book> getAll() {
		return em.createQuery("From Book").getResultList();
	}
	
	@Transactional
	public void delete(Book book) {
		em.remove(book);
		
	}
	
	@Transactional
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		em.remove(em.find(Book.class, id));
	}
}
