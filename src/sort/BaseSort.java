package sort;

public class BaseSort {
	private long timeToRun;
	protected long steps;
	protected long swaps;

	protected String myName = "No name";

	public BaseSort() {

	}

	public String getName() {
		return myName;
	}

	public <Type extends Comparable<? super Type>> void sort(Type[] list) {
		long start = System.currentTimeMillis();
		sortList(list);
		timeToRun = System.currentTimeMillis() - start;

	}

	public long getTimeToRun() {
		return timeToRun;
	}

	public long getSteps() {
		return steps;
	}

	public long getSwaps() {
		return swaps;
	}

	public <Type extends Comparable<? super Type>> void sortList(Type[] list) {

	}

	protected void swap(Object[] list, int index1, int index2) {
		Object temp = list[index2];
		list[index2] = list[index1];
		list[index1] = temp;
		swaps++;
	}

}
