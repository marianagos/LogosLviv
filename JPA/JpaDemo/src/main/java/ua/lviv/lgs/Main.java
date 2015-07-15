package ua.lviv.lgs;

import ua.lviv.lgs.dao.AuthorDao;
import ua.lviv.lgs.dao.DaoFactory;

public class Main {

	public static void main(String[] args) {
		AuthorDao aDao = DaoFactory.getInstance().getAuthorDao();
		Author a = new Author("Taras", 56);
		aDao.create(a);

		// EntityManagerFactory factory =
		// Persistence.createEntityManagerFactory("primary");
		// EntityManager em = factory.createEntityManager();
		// em.getTransaction().begin();

		// Query query = em.createNamedQuery("Author.findByName", Author.class)
		// .setParameter("name", "Tolkien");
		// List<Author> results = query.getResultList();
		// System.out.println(results);

		// AuthorDaoImpl daoImpl = new AuthorDaoImpl();
		// daoImpl.setEntityManager(em);
		// System.out.println(daoImpl.findAll());

		// Add
		// em.persist(new Author("Tolkien", 124));

		// Book b = new Book("LOTR");
		// b.setAuthor(em.find(Author.class, 4));
		// em.persist(b);

		// Delete
		// em.remove(em.find(Author.class, 6));

		// Update
		// Book b = em.find(Book.class, 1);
		// b.setTitle("Hobbit");
		// b.setId(4); // FORBIDEN
		// em.merge(new Book("sdfsdg"));
		// b = em.find(Book.class, 3);
		// b.setAuthor(em.find(Author.class, 1));
		// em.merge(b);

		// Find All
		//
		// List<Book> books = em.createQuery("from Book").getResultList();
		// for (Book book : books) {
		// System.out.println(book);
		// }

		// Find all TITLES
		// List<String> titles = em.createQuery("select b.title from Book b")
		// .getResultList();
		// System.out.println(titles);

		// List<Author> authors = em.createQuery(
		// "from Author a where a.name like 'Tol%'").getResultList();
		// System.out.println(authors);
		// Author a = (Author) em.createQuery("from Author a where a.age=124")
		// .getSingleResult(); // only when result is REALLY SINGLE!!!

//		em.getTransaction().commit();
//		em.close();
//		factory.close();

	}

}
