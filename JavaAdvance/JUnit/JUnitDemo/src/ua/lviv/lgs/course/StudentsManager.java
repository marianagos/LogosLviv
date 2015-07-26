package ua.lviv.lgs.course;

import java.util.ArrayList;
import java.util.Collection;

public class StudentsManager {

	private Collection<Student> students;

	public StudentsManager(Collection<Student> students) {
		this.students = students;
	}

	public Collection<Student> findByName(String name) {
		Collection<Student> result = new ArrayList<>();
		for (Student s : students) {
			if (s.name.equalsIgnoreCase(name)) {
				result.add(s);
			}
		}
		return result;
	}

	public Collection<Student> findBySurname(String surname) {
		Collection<Student> result = new ArrayList<>();
		for (Student s : students) {
			if (s.surname.equalsIgnoreCase(surname)) {
				result.add(s);
			}
		}
		return result;
	}
}
