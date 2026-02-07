import java.util.*;

public class Sorting {
	public static <T extends Comparable<? super T>> void mergesort(List<T> list) {
		mergesort(list, Comparator.naturalOrder());
	}

	public static <T> void mergesort(List<T> list, Comparator<? super T> c) {
		if (list == null || list.size() <= 1) return;
		mergeSortFunc(list, 0, list.size() - 1, c);
	}

	private static <T> void mergeSortFunc(List<T> list, int l, int r, Comparator<? super T> c) {
		if (l >= r) return;

		int mid = (l + r) / 2;

		mergeSortFunc(list, l, mid, c);
		mergeSortFunc(list, mid + 1, r, c);
		merge(list, l, mid, r, c);
	}

	private static <T> void merge(List<T> list, int l, int mid, int r, Comparator<? super T> c) {
		ArrayList<T> temp = new ArrayList<>(r - l + 1);

		int i = l;
		int j = mid + 1;

		while (i <= mid && j <= r) {
			if (c.compare(list.get(i), list.get(j)) <= 0) {
				temp.add(list.get(i++));
			} else {
				temp.add(list.get(j++));
			}
		}

		while (i <= mid) temp.add(list.get(i++));
		while (j <= r) temp.add(list.get(j++));

		for (int k = 0; k < temp.size(); k++) {
			list.set(l + k, temp.get(k));
		}
	}

	public static <T extends Comparable<? super T>> void quicksort(List<T> list) {
		quicksort(list, Comparator.naturalOrder());
	}

	public static <T> void quicksort(List<T> list, Comparator<? super T> c) {
		if (list == null || list.size() <= 1) return;
		Collections.shuffle(list);
		quickSortFunc(list, 0, list.size() - 1, c);
	}

	private static <T> void swap(List<T> list, int l, int r) {
		T temp = list.get(l);
		list.set(l, list.get(r));
		list.set(r, temp);
	}

	private static <T> void quickSortFunc(List<T> list, int l, int h, Comparator<? super T> c) {
		if (l >= h) return;

		T piv = list.get(l);

		int lt = l;
		int gt = h;
		int i = l + 1;

		while (i <= gt) {
			int compareRes = c.compare(list.get(i), piv);
			if (compareRes < 0) {
				swap(list, lt++, i++);
			} else if (compareRes > 0) {
				swap(list, i, gt--);
			} else {
				i++;
			}
		}

		quickSortFunc(list, l, lt - 1, c);
		quickSortFunc(list, gt + 1, h, c);
	}

	public static <T> void sort(List<T> list, Comparator<? super T> c, String sortName) {
		if (list == null || list.size() <= 1) return;

		if (sortName.equals("mergesort")) {
			mergesort(list, c);
		} else if (sortName.equals("quicksort")) {
			quicksort(list, c);
		} else {
			throw new IllegalArgumentException("Invalid sort type");
		}
	}

	






































}