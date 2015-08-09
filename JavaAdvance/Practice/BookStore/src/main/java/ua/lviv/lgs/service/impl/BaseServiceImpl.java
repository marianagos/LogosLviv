package ua.lviv.lgs.service.impl;

import java.util.List;

import ua.lviv.lgs.dao.BaseDao;
import ua.lviv.lgs.service.BaseService;

public abstract class BaseServiceImpl<T> implements BaseService<T> {
	public List<T> findAll() {
		return getMainDao().findAll();
	}

	public void create(T entity) {
		getMainDao().create(entity);

	}

	public T findById(Object id) {
		return getMainDao().findById(id);
	}

	public void delete(T entity) {
		getMainDao().delete(entity);
	}

	public void deleteAll() {
		getMainDao().deleteAll();
	}

	public T update(T entity) {
		return getMainDao().update(entity);
	}

	public List<T> findByProperty(String property, Object value) {
		return getMainDao().findByProperty(property, value);
	}

	public int count() {
		return getMainDao().count();
	}
	
	public abstract BaseDao<T> getMainDao();

}
