package ua.lviv.lgs.junit;

import ua.lviv.lgs.utils.ArrayUtils;
import junit.framework.TestCase;

public class SimpleTestCase extends TestCase {

	private int array[] = new int[] { 3, 5, 5, 2, 4, 6, 7, 9, 3, 21, 1 };

	public void testMaxValue() {
		assertEquals("The max element should be 21", 21, ArrayUtils.findMaxValue(array));
	}

	public void testMaxIndex() {
		assertEquals("Index should be 9", 9, ArrayUtils.findMaxIndex(array));
	}
}
