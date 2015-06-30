package ua.lviv.lgs.junit;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@SuiteClasses({ NioStudentReaderTest.class, DefaultStudentReaderTest.class })
public class StudentsReaderSuit {

	@BeforeClass
	public static void beforeStart() throws IOException {
		System.out.println("Starting suit for students reader...");
	}
}
