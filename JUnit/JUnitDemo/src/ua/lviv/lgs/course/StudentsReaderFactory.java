package ua.lviv.lgs.course;

public class StudentsReaderFactory {
	public static StudentsReader getStudentsReader() {
		return new DefaultStudentsReader();
	}
}
