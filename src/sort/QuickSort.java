package sort;


public class QuickSort extends BaseSort {
	public QuickSort() {
		myName = "QuickSort";
	}

	public <Type extends Comparable<? super Type>> void sortList(Type[] list) {
		// recursive starts here
		quickSort(list, 0, list.length - 1);
	}

	private <Type extends Comparable<? super Type>> Type getOptimalPivot(Type first, Type mid, Type last) {
		Type pivot;

		// first one is biggest, so the pivot is either the middle or last one
		if ((first.compareTo(mid) + first.compareTo(last)) == 2) {
			if (mid.compareTo(last) == 1)
				pivot = mid;
			else
				pivot = last;
			return pivot;
		}

		// middle one is biggest, so the pivot is either the first or last one
		if ((mid.compareTo(first) + mid.compareTo(last)) == 2) {
			if (first.compareTo(last) == 1)
				pivot = last;
			else
				pivot = first;
			return pivot;
		}

		// last one is biggest, so the pivot is either the first or middle one
		if ((last.compareTo(mid) + last.compareTo(first)) == 2) {
			if (first.compareTo(mid) == 1)
				pivot = mid;
			else
				pivot = first;
			return pivot;
		}
		// no biggest? doesn't matter
		return mid;

	}


	private <Type extends Comparable<? super Type>> void quickSort(Type[] list, int startindex, int endindex) {

		if ((endindex - startindex) < 2)
			return;

		if (endindex - startindex == 2) {
			if (list[startindex].compareTo(list[endindex - 1]) == 1)
				swap(list, startindex, endindex - 1);
			return;
		}
		Type first, mid, last, pivot;

		int midindex = (startindex + endindex) / 2;

		first = list[startindex];
		mid = list[midindex];
		last = list[endindex - 1];

		pivot = getOptimalPivot(first, mid, last);

		int i = startindex;
		int j = endindex;

		while (i <= j) {
			steps++;
			while (list[i].compareTo(pivot) == -1)
				i++;
			while (list[j].compareTo(pivot) == 1)
				j--;
			if (i <= j) {
				swap(list, i, j);
				i++;
				j--;
			}
		}

		if (startindex < (i - 1))
			quickSort(list, startindex, i - 1);
		if (i < endindex)
			quickSort(list, i, endindex);
	}
}
