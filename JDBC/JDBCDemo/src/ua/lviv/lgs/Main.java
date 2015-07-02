package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
	public static final String URL = "jdbc:mysql://localhost/logos";
	public static final String USER = "root";
	public static final String PASSWORD = "root";

	private static Connection conn;

	public static void main(String[] args) throws SQLException {
		Person p1 = new Person("Bogdan", 19, new java.util.Date());
		Person p2 = new Person("Stepan", 29, new java.util.Date());

		Collection<Person> toInsert = new ArrayList<>();
		toInsert.add(p1);
		toInsert.add(p2);

		PeopleManager manager = new PeopleManager();
		manager.initDatabase();

		manager.insert(toInsert);
		// manager.insert(p1);
		// manager.insert(p2);

		Collection<Person> people = manager.findAll();
		for (Person p : people) {
			System.out.println(p);
		}
	}

	private static void demo() throws SQLException {
		// Class.forName("com.mysql.jdbc.Driver");
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PreparedStatement ps = conn.prepareStatement("create table if not exists person" + "(`id` int not null auto_increment, "
				+ "`name` varchar(40), `born` date, `age` int, primary key (id), UNIQUE KEY (name))");
		ps.execute();

		ps = conn.prepareStatement("insert into person (name,born,age) values (?,?,?)");
		ps.setString(1, "Oleg5");
		ps.setDate(2, new Date(new java.util.Date().getTime()));
		ps.setInt(3, 41);

		ps.execute();

		List<Person> list = new ArrayList<Person>();
		ResultSet res = ps.executeQuery("select * from person");
		while (res.next()) {
			list.add(new Person(res.getString(2), res.getInt(4), res.getDate(3)));

		}
		for (Person person : list) {
			System.out.println(person);
		}

		conn.close();

	}

}
