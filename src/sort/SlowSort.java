package sort;


public class SlowSort extends BaseSort {

	public SlowSort() {
		myName = "SlowSort";
	}

	public <Type extends Comparable<? super Type>> void sortList(Type[] list) {
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list.length; j++) {
				steps++;
				if (list[i].compareTo(list[j]) == -1)
					swap(list, i, j);
			}
		}
	}
}
