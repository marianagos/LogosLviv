package ua.lviv.lgs.utils;

public class ArrayUtils {

	public static int findMaxValue(int[] array) {
		return array[findMaxIndex(array)];
	}

	public static int findMaxIndex(final int[] array) {
		int maxIndex = 0;

		for (int i = 1; i < array.length; i++) {
			if (array[maxIndex] < array[i]) {
				maxIndex = i;
			}
		}

		return maxIndex;
	}
}
