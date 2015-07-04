package ua.lviv.lgs;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class StudentsManager {
	private List<Student> students;

	public StudentsManager(List<Student> students) {
		this.students = students;
	}

	public List<Student> findByName(String name) {
		if (name == null) {
			throw new InvalidParameterException("Name should not be null");
		}
		List<Student> result = new ArrayList<>();
		for (Student s : students) {
			if (name.equals(s.getName())) {
				result.add(s);
			}
		}
		return result;
	}
}
