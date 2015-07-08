package ua.lviv.lgs;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

public class Main {

	/*
	 * public static void main(String[] args) { // Configuration configuration =
	 * new Configuration().configure(); // StandardServiceRegistry registry =
	 * new //
	 * StandardServiceRegistryBuilder().applySettings(configuration.getProperties
	 * ()).build(); // SessionFactory factory =
	 * configuration.buildSessionFactory(registry);
	 * 
	 * // Author a1 = new Author(1, "firstName", "lastName", 21);
	 * 
	 * AuthorDao aDao = new AuthorDao();
	 * 
	 * Author a = new Author("Ivan", "Melnychuk", 25); a.setBirthday(new
	 * Date()); a.setColor(Color.BLUE); aDao.create(a);
	 * System.out.println(aDao.findAll()); // Book b = new Book("Book 1");
	 * 
	 * // List<Book> books = new ArrayList<>();
	 * 
	 * // books.add(b); // a.setBooks(books);
	 * 
	 * // a = aDao.findById(2); // aDao.delete(a);
	 * 
	 * // System.out.println(a2.getId());
	 * 
	 * HibernateUtils.shutdown(); }
	 */

	public static void main(String[] args) {
		System.out.println("Hibernate many to many (Annotation)");
		Session session = HibernateUtils.getSessionFactory().openSession();

		session.beginTransaction();

		Movie stock = new Movie();
		stock.setMovieName("PADINI");

		Category category1 = new Category("CONSUMER", "CONSUMER COMPANY");
		Category category2 = new Category("INVESTMENT", "INVESTMENT COMPANY");

		Set<Category> categories = new HashSet<Category>();
		categories.add(category1);
		categories.add(category2);

		stock.setCategories(categories);

		session.save(stock);

		session.getTransaction().commit();
		System.out.println("Done");
	}

}
