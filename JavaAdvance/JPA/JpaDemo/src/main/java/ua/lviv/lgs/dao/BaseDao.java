package ua.lviv.lgs.dao;

public interface BaseDao<T> {
	void create(T a);

	T findById(Object id);

}
