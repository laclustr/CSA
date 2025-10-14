import java.util.Random;
import java.util.Arrays;

public class TueOct14 {
	public static void main(String[] args) {
		Random rng = new Random(67);

		int N = 60600;

		int[] arr = new int[N];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (rng.nextDouble() * 500 + 1);
		}

		int[] arr2 = Arrays.copyOf(arr, arr.length);

		long start = System.currentTimeMillis();
		bubbleSort(arr);
		long finish = System.currentTimeMillis();
		System.out.println("Bubble Sort: " + (finish - start) / 1000.f);

		start = System.currentTimeMillis();
		selectionSort(arr2);
		finish = System.currentTimeMillis();
		System.out.println("Selection Sort: " + (finish - start) / 1000.f);

	}

	public static void swap(int[] li, int idx1, int idx2) {
		int temp = li[idx1];
		li[idx1] = li[idx2];
		li[idx2] = temp;
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
			int minIdx = i;

			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[minIdx]) minIdx = j;
			}
			swap(arr, minIdx, i);
		}
	}

	public static boolean isSorted(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) return false;
		}
		return true;
	}
}