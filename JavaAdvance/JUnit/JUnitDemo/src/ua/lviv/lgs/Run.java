package ua.lviv.lgs;

import java.io.IOException;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import ua.lviv.lgs.junit.StudentsReaderSuit;
import junit.textui.TestRunner;

public class Run {
	public static void main(String[] args) throws IOException {
		// EMPTY
		Result result = JUnitCore.runClasses(StudentsReaderSuit.class);
	    for (Failure failure : result.getFailures()) {
	      System.out.println(failure.toString());
	    }
	}
}
