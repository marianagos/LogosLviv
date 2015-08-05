package ua.lviv.lgs.dao;

import java.util.List;

public interface BaseDao <E> {
	
	void insert(E e);
	
	E findById (int id);
	
	List<E> getAll();
}
