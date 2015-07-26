package ua.lviv.lgs.junit;

import ua.lviv.lgs.course.DefaultStudentsReader;
import ua.lviv.lgs.course.StudentsReader;

public class DefaultStudentReaderTest extends StudentReaderTest {
	@Override
	public StudentsReader getStudentsReader() {
		StudentsReader result = new DefaultStudentsReader();
		System.out.println("Testing " + result);
		return result;
	}
}
