import java.util.*;
@SuppressWarnings("unchecked")
public class MaxPQ<E extends Comparable<E>>  {
	private int n;
	private E[] arr;

	public MaxPQ() {
		arr = (E[]) new Comparable[8];
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	public void add(E e) {
		if (n == arr.length - 1) resize(arr.length * 2);

		arr[++n] = e;
		swim(n);
	}

	public E getMax() {
		if (this.isEmpty()) return null;
		return arr[1];
	}

	public E delMax() {
		if (this.isEmpty()) return null;

		E max = arr[1];
		swap(1, n--);
		sink(1);

		if (n > 0 && n == (arr.length - 1) / 4) resize(arr.length / 2);

		return max;
	}

	private void swim(int i) {
		while (i > 1 && less(i / 2, i)) {
			swap(i, i / 2);
			i /= 2;
		}
	}

	private void sink(int i) {
		while (2 * i <= n) {
			int j = 2 * i;

			if (j < n && less(j, j + 1)) j++;

			if (!less(i, j)) break;

			swap(i, j);
			i = j;
		}
	}

	private boolean less(int i, int j) {
		return arr[i].compareTo(arr[j]) < 0;
	}

	private void swap(int i, int j) {
		E temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private void resize(int s) {
		E[] temp = (E[]) new Comparable[s];
		for (int i = 1; i <= n; i++) {
			temp[i] = arr[i];
		}
		arr = temp;
	}
}