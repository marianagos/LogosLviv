package ua.lviv.lgs.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.lgs.dao.AuthorDao;
import ua.lviv.lgs.domain.Author;

@Repository
public class AuthorDaoImpl extends BaseDaoImpl<Author> implements AuthorDao{

	public AuthorDaoImpl() {
		super(Author.class);
		// TODO Auto-generated constructor stub
	}
	
}
