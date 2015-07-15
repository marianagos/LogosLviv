package ua.lviv.lgs.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {
	protected Class<T> entityClass;
	protected EntityManager em;

	public BaseDaoImpl() {
		entityClass = getEntityClass();
	}

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public List<T> findAll() {
		final CriteriaBuilder builder = em.getCriteriaBuilder();
		final CriteriaQuery<T> criteria = builder.createQuery(entityClass);
		final Root<T> root = criteria.from(entityClass);
		criteria.select(root);
		final TypedQuery<T> query = em.createQuery(criteria);
		return query.getResultList();
	}

	public T findById(Object id) {
		return em.find(entityClass, id);
	}

	public void update(T entity) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	protected final Class<T> getEntityClass() {
		final Type type = getClass().getGenericSuperclass() instanceof ParameterizedType ? getClass()
				.getGenericSuperclass() : getClass().getSuperclass()
				.getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			final ParameterizedType paramType = (ParameterizedType) type;
			return (Class<T>) paramType.getActualTypeArguments()[0];
		} else
			throw new IllegalArgumentException(
					"Could not guess entity class by reflection");
	}

}
