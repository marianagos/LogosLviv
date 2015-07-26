package ua.lviv.lgs;

import static org.junit.Assert.assertEquals;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class StudentsManagerTestv4 {
	private static List<Student> students;

	@BeforeClass
	public static void init() {
		Student a = new Student("Bogdan", "Melnychuk");
		Student b = new Student("Ivan", "Melnychuk");
		Student c = new Student("Bogdan", "Melnyk");
		Student d = new Student(null, "Melnychuk");

		students = new ArrayList<>();
		students.add(a);
		students.add(b);
		students.add(c);
		students.add(d);
	}

	@Test
	public void findByName() {
		System.out.println("findByName");

		final String name = "Bogdan";
		final StudentsManager manager = new StudentsManager(students);
		final List<Student> filtered = manager.findByName(name);

		assertEquals(2, filtered.size());
		for (Student s : filtered) {
			assertEquals(name, s.getName());
		}
	}

	@Test(expected = InvalidParameterException.class)
	public void testInvalidParam() {
		System.out.println("testInvalidParam");
		Student a = new Student(null, "Melnychuk");
		Student b = new Student("Ivan", "Melnychuk");

		List<Student> students = new ArrayList<>();
		students.add(a);
		students.add(b);

		final StudentsManager manager = new StudentsManager(students);
		manager.findByName(null);
	}

	@Test
	public void codeCoverageTest() {
		boolean bool = true;
		if (bool) {
			System.out.println("findByName");

			final String name = "Bogdan";
			final StudentsManager manager = new StudentsManager(students);
			final List<Student> filtered = manager.findByName(name);

			assertEquals(2, filtered.size());
			for (Student s : filtered) {
				assertEquals(name, s.getName());
			}
		} else {
			Student a = new Student(null, "Melnychuk");
			Student b = new Student("Ivan", "Melnychuk");

			List<Student> students = new ArrayList<>();
			students.add(a);
			students.add(b);

			final StudentsManager manager = new StudentsManager(students);
			manager.findByName(null);
		}
	}
}
