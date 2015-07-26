package ua.lviv.lgs.dao.db;

import javax.persistence.EntityManager;

import ua.lviv.lgs.Author;
import ua.lviv.lgs.dao.AuthorDao;

public class AuthorDbDao extends BaseDbDao<Author> implements AuthorDao {

	public AuthorDbDao(EntityManager em) {
		super(em);
	}

	public Author findByAge(int age) {
		// TODO Auto-generated method stub
		return null;
	}

}
