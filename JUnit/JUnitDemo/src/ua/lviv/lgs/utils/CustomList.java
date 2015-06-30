package ua.lviv.lgs.utils;

public class CustomList {
	private int[] data;
	private int size;

	public CustomList(int maxCapacity) {
		data = new int[maxCapacity];
	}

	public void addValue(int value) {
		data[size++] = value;
	}

	public int findMax() {
		throw new UnsupportedOperationException("Not Implemented yet");
	}
}
