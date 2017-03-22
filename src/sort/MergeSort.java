package sort;



public class MergeSort extends BaseSort {
	public MergeSort() {
		myName = "MergeSort";
	}

	public <Type extends Comparable<? super Type>> void sortList(Type[] list) {
		mergeSort(list);
	}

	public <Type extends Comparable<? super Type>> void mergeSort(Type[] list) {
		if (list.length == 1)
			return;
		int mid = (list.length / 2);

		Type[] left = (Type[]) new Comparable[mid];
		Type[] right = (Type[]) new Comparable[list.length - mid];

		for (int i = 0; i < list.length; i++) {
			if (i < mid)
				left[i] = list[i];
			else
				right[i - mid] = list[i];
		}
		mergeSort(left);
		mergeSort(right);
		merge(left, right, list);

	}

	public <Type extends Comparable<? super Type>> void merge(Type[] left, Type[] right, Type[] list) {

		int leftIndex, rightIndex, resultIndex;
		leftIndex = 0;
		rightIndex = 0;
		resultIndex = 0;
		while (leftIndex < left.length && rightIndex < right.length) {
			steps++;
			if (left[leftIndex].compareTo(right[rightIndex]) <= 0) {
				swaps++;
				list[resultIndex++] = left[leftIndex++];
			} else {
				swaps++;
				list[resultIndex++] = right[rightIndex++];
			}
		}
		while (leftIndex < left.length) {
			swaps++;
			list[resultIndex++] = left[leftIndex++];
		}
		while (rightIndex < right.length - 1) {
			swaps++;
			list[resultIndex++] = right[rightIndex++];
		}
	}
}
