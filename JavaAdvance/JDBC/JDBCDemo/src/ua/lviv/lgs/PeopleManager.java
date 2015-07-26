package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class PeopleManager {
	public static final String URL = "jdbc:mysql://localhost/logos";
	public static final String USER = "root";
	public static final String PASSWORD = "root";

	private Connection connection;

	public PeopleManager() throws SQLException {
		openConnection();
	}

	private void openConnection() throws SQLException {
		connection = DriverManager.getConnection(URL, USER, PASSWORD);
	}

	private void closeConnection() throws SQLException {
		connection.close();
	}

	public void initDatabase() throws SQLException {
		checkConnection();
		PreparedStatement ps = connection.prepareStatement("create table if not exists person" + "(`id` int not null auto_increment, "
				+ "`name` varchar(40), `born` date, `age` int, primary key (id), UNIQUE KEY (name))");
		ps.execute();
		closeConnection();
	}

	private void checkConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			openConnection();
		}
	}

	public void insert(Person person) throws SQLException {
		checkConnection();

		PreparedStatement ps = connection.prepareStatement("insert into person (name,born,age) values (?,?,?)");
		ps.setString(1, person.getName());
		ps.setDate(2, new Date(person.getBirthday().getTime()));
		ps.setInt(3, person.getAge());
		ps.execute();
		
		closeConnection();
	}

	public void insert(Collection<Person> persons) throws SQLException {
		checkConnection();

		boolean autoCommit = connection.getAutoCommit();
		connection.setAutoCommit(false);

		PreparedStatement ps = connection.prepareStatement("insert into person (name,born,age) values (?,?,?)");
		for (Person p : persons) {
			ps.setString(1, p.getName());
			ps.setDate(2, new Date(p.getBirthday().getTime()));
			ps.setInt(3, p.getAge());
			ps.execute();
		}

		connection.commit();
		connection.setAutoCommit(autoCommit);
		closeConnection();
	}

	public Collection<Person> findAll() throws SQLException {
		Collection<Person> result = new ArrayList<Person>();
		PreparedStatement ps = connection.prepareStatement("select * from person");
		ResultSet res = ps.executeQuery();
		while (res.next()) {
			result.add(new Person(res.getString(2), res.getInt(4), res.getDate(3)));
		}

		closeConnection();
		return result;
	}
}
