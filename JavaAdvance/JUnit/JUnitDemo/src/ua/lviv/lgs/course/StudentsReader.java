package ua.lviv.lgs.course;

import java.io.IOException;
import java.util.Collection;

public interface StudentsReader {
	Collection<Student> readFromFile(String fileName) throws IOException;
}
