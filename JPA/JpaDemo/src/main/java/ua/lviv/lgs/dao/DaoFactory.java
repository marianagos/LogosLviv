package ua.lviv.lgs.dao;

import ua.lviv.lgs.dao.db.AuthorDbDao;
import ua.lviv.lgs.dao.db.BookDbDao;

public class DaoFactory {
	private static DaoFactory instance;
	private AuthorDao aDao;
	private BookDao bDao;

	private DaoFactory() {
		aDao = new AuthorDbDao();
		bDao = new BookDbDao();
	}

	public static DaoFactory getInstance() {
		if (instance == null) {
			instance = new DaoFactory();
		}
		return instance;
	}

	public AuthorDao getAuthorDao() {
		return aDao;
	}

	public BookDao getBookDao() {
		return bDao;
	}
}
