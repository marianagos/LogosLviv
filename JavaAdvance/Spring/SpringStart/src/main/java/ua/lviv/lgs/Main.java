package ua.lviv.lgs;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.lviv.lgs.dao.AuthorDao;
import ua.lviv.lgs.domain.Author;

public class Main {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"appContext.xml");
		AuthorDao dao = (AuthorDao) context.getBean("aDao");
		dao.insertAuthor(new Author("Rolling", 256));
		context.close();

	}

}
