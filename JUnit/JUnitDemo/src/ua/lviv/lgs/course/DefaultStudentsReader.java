package ua.lviv.lgs.course;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class DefaultStudentsReader implements StudentsReader {
	public Collection<Student> readFromFile(String fileName) throws IOException {
		final Collection<Student> result = new ArrayList<Student>();

		final BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line;

		try {
			while ((line = br.readLine()) != null) {
				String[] splitted = line.split(" ");
				if (splitted.length == 2) {
					final Student student = new Student(splitted[0], splitted[1]);
					result.add(student);
				}
			}
		} finally {
			br.close();
		}

		return result;
	}
}
