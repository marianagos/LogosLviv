package ua.lviv.lgs.dao;

import java.util.List;

public interface BaseDao<T> {
	List<T> findAll();
	void create(T entity);
	T findById(Object id);
}
