package ua.lviv.lgs.course;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NioStudentsReader implements StudentsReader {

	public Collection<Student> readFromFile(String fileName) throws IOException {
		final Collection<Student> result = new ArrayList<Student>();

		List<String> lines = Files.readAllLines(Paths.get(fileName), Charset.defaultCharset());

		for (String s : lines) {
			String[] splitted = s.split(" ");
			if (splitted.length == 2) {
				final Student student = new Student(splitted[0], splitted[1]);
				result.add(student);
			}
		}

		return result;
	}
}
