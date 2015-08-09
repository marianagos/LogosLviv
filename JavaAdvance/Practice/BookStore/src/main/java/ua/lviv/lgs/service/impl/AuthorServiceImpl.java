package ua.lviv.lgs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.AuthorDao;
import ua.lviv.lgs.dao.BaseDao;
import ua.lviv.lgs.domain.Author;
import ua.lviv.lgs.service.AuthorService;

@Service
public class AuthorServiceImpl extends BaseServiceImpl<Author> implements AuthorService {
	@Autowired
	private AuthorDao dao;

	@Override
	public BaseDao<Author> getMainDao() {
		return dao;
	}
	

	

}
