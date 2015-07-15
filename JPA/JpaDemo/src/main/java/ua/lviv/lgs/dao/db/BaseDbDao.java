package ua.lviv.lgs.dao.db;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.lviv.lgs.dao.BaseDao;

public class BaseDbDao<T> implements BaseDao<T> {

	protected EntityManager em;
	
	public BaseDbDao() {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("primary");
		em = emFactory.createEntityManager();
	}
	
	
	public void create(T a) {
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
	}

	public T findById(Object id) {
		return em.find(getEntityClass(), id);
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
