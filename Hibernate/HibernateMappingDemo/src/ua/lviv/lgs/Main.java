package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

public class Main {

	public static void main(String[] args) {
		// Configuration configuration = new Configuration().configure();
		// StandardServiceRegistry registry = new
		// StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		// SessionFactory factory = configuration.buildSessionFactory(registry);

		//Author a1 = new Author(1, "firstName", "lastName", 21);
		
		AuthorDao aDao = new AuthorDao();

		Author a = new Author(0, "Bogdan", "Melnychuk", 25);
		Book b = new Book(0, "Book 1");
		b.setAuthor(a);
		
		List<Book> books = new ArrayList<>();
		
		books.add(b);
		a.setBooks(books);
		
		
		
		aDao.create(a);
		//System.out.println(a2.getId());
		
		
		HibernateUtils.shutdown();
	}

}
