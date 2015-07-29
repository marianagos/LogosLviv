package ua.lviv.lgs.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ua.lviv.lgs.dao.AuthorDao;
import ua.lviv.lgs.domain.Author;

@Repository
public class AuthorDaoImpl extends BaseDaoImpl<Author> implements AuthorDao {
	@Transactional
	public List<Author> getByName(String name) {
		return getEm().createNamedQuery("Author.findByName")
				.setParameter("name", name).getResultList();
	}

}
