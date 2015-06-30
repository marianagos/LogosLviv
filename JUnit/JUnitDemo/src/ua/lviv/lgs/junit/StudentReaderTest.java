package ua.lviv.lgs.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ua.lviv.lgs.course.Student;
import ua.lviv.lgs.course.StudentsReader;
import ua.lviv.lgs.course.StudentsReaderFactory;

public class StudentReaderTest {

	private StudentsReader studentsReader = getStudentsReader();

	@BeforeClass
	public static void beforeStart() throws IOException {
		File f = new File("empty.txt");
		f.createNewFile();
	}

	@AfterClass
	public static void afterStop() {
		File f = new File("empty.txt");
		f.delete();
	}

	@Test(expected = IOException.class)
	public void shouldThrowException() throws IOException {
		studentsReader.readFromFile("nonExisitngFile.txt");
		fail("IOException should be thrown");
	}

	@Test
	public void shouldReadFromFile() throws IOException {
		Collection<Student> students = studentsReader.readFromFile("students.txt");
		assertEquals("Expected size is 3", 3, students.size());
	}

	public StudentsReader getStudentsReader() {
		StudentsReader reader = StudentsReaderFactory.getStudentsReader();
		System.out.println("Testing " + reader.getClass().getName());
		return reader;
	}
}
