package ua.lviv.lgs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.BaseDao;
import ua.lviv.lgs.dao.BookDao;
import ua.lviv.lgs.domain.Book;
import ua.lviv.lgs.service.BookService;

@Service
public class BookServiceImpl extends BaseServiceImpl<Book> implements
		BookService {
	@Autowired
	private BookDao bDao;

	@Override
	public BaseDao<Book> getMainDao() {
		return bDao;
	}

}
