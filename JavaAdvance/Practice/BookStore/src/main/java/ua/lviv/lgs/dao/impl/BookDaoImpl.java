package ua.lviv.lgs.dao.impl;

import org.springframework.stereotype.Repository;

import ua.lviv.lgs.dao.BookDao;
import ua.lviv.lgs.domain.Book;

@Repository
public class BookDaoImpl extends BaseDaoImpl<Book> implements BookDao {
}
