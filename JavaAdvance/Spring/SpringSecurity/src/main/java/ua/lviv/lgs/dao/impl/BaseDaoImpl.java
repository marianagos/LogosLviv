package ua.lviv.lgs.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import ua.lviv.lgs.dao.BaseDao;

public class BaseDaoImpl<E> implements BaseDao<E> {
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	private Class<E> entityClass;

	public BaseDaoImpl(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Transactional
	public void insert(E e) {
		em.merge(e);
	}

	@Transactional
	public E findById(int id) {
		// TODO Auto-generated method stub
		return em.find(entityClass, id);
	}

	@Transactional
	public List<E> getAll() {
		return em.createQuery("from " + entityClass.getSimpleName())
				.getResultList();
	}

}
