package ua.lviv.lgs.junit;

import ua.lviv.lgs.course.NioStudentsReader;
import ua.lviv.lgs.course.StudentsReader;

public class NioStudentReaderTest extends StudentReaderTest {
	@Override
	public StudentsReader getStudentsReader() {
		StudentsReader result = new NioStudentsReader();
		System.out.println("Testing " + result);
		return result;
	}
}
