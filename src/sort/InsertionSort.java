package sort;


public class InsertionSort extends BaseSort {
	public InsertionSort() {
		myName = "InsertionSort";
	}

	public <Type extends Comparable<? super Type>> void sortList(Type[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			int j = i;
			Type first;
			Type second;
			while (j != -1) {
				steps++;
				first = list[j];
				second = list[j + 1];
				if (second.compareTo(first) == -1) {
					swap(list, j, j + 1);
				}
				j--;
			}
		}

	}
}
