import java.util.Random;
import java.util.Arrays;

public class WedOct15 {
	public static void main(String[] args) {
		final int N = 67000;
		final long seed = 67L;
		long start, end;

		Random rng = new Random(seed);

		int[] arr = new int[N];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (rng.nextDouble() * 101);
		}

		start = System.currentTimeMillis();
		insertionSort(arr);
		end = System.currentTimeMillis();
		System.out.println((end - start) / 1000.d);
		System.out.println(isSorted(arr));
	}

	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int j = i;

			while (j > 0 && arr[j] < arr[j - 1]) {
				swap(arr, j--, j);
			}
		}
	}

	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			boolean swapped = false;
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {swap(arr, j, j + 1); swapped = true;}
			}
			if (!swapped) return;
		}
	}

	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIdx = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] < arr[minIdx]) minIdx = j;
			}
			swap(arr, minIdx, i);
		}
	}

	public static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

	public static boolean isSorted(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) return false;
		}

		return true;
	}

	public static String arr2Str(int[] arr) {
		StringBuilder s = new StringBuilder("{");

		for (int i = 0; i < arr.length; i++) {
			if (i < arr.length - 1) { s.append(arr[i]); s.append(", ");}
			else s.append(arr[i]);
		}
		s.append("}");

		return s.toString();
	}
}