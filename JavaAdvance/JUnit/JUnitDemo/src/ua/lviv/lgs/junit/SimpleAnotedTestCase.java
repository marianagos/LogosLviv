package ua.lviv.lgs.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ua.lviv.lgs.utils.ArrayUtils;

public class SimpleAnotedTestCase {

	private int array[] = new int[] { 3, 5, 5, 2, 4, 6, 7, 9, 3, 21, 1 };

	@Test
	public void shouldFindMaxValue() {
		assertEquals("The max element should be 21", 21, ArrayUtils.findMaxValue(array));
	}

	@Test
	public void shouldFindMaxIndex() {
		assertEquals("Index should be 9", 9, ArrayUtils.findMaxIndex(array));
	}
}
