package ua.lviv.lgs;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class StudentsManagerTest extends TestCase {

	public void testfindByName() {
		Student a = new Student("Bogdan", "Melnychuk");
		Student b = new Student("Ivan", "Melnychuk");
		Student c = new Student("Bogdan", "Melnyk");
		Student d = new Student(null, "Melnychuk");

		List<Student> students = new ArrayList<>();
		students.add(a);
		students.add(b);
		students.add(c);
		students.add(d);

		final String name = "Bogdan";
		final StudentsManager manager = new StudentsManager(students);
		final List<Student> filtered = manager.findByName(name);

		assertEquals(2, filtered.size());
		for (Student s : filtered) {
			assertEquals(name, s.getName());
		}
	}

	public void testInvalidStudent() {
		Student a = new Student(null, "Melnychuk");
		Student b = new Student("Ivan", "Melnychuk");

		List<Student> students = new ArrayList<>();
		students.add(a);
		students.add(b);

		final String name = "Ivan";
		final StudentsManager manager = new StudentsManager(students);
		final List<Student> filtered = manager.findByName(name);

		assertEquals(1, filtered.size());
		for (Student s : filtered) {
			assertEquals(name, s.getName());
		}
	}

	public void testInvalidParam() {
		Student a = new Student(null, "Melnychuk");
		Student b = new Student("Ivan", "Melnychuk");

		List<Student> students = new ArrayList<>();
		students.add(a);
		students.add(b);

		final StudentsManager manager = new StudentsManager(students);
		try {
			manager.findByName(null);
		} catch (InvalidParameterException e) {
			assertNotNull(e);
		}
	}
}
