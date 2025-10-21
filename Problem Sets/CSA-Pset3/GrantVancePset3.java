import java.util.*;

public class GrantVancePset3 {
	public static void main(String[] args) {
		System.out.println(linSearch(new int[] {1, 3, 1, 2, 4}, 1)); // 0
		System.out.println(linSearch(new int[] {1, 3, 1, 2, 4}, 3)); // 1
		System.out.println(linSearch(new int[] {1, 3, 1, 2, 4}, 5)); // -1

		System.out.println(binSearch(new String[] {"apple", "banana", "lime", "yucca"}, "lime")); // 2
		System.out.println(binSearch(new String[] {"apple", "banana", "lime", "yucca"}, "lemon")); // -1

		int[] arr = {2, 3, 1, -1, -4};
		selSort(arr);
		System.out.println(Arrays.toString(arr)); // [-4, -1, 1, 2, 3]

		arr = new int[] {2, 3, 1, -1, -4};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr)); // [-4, -1, 1, 2, 3]

		arr = new int[] {2, 3, 1, -1, -4};
		insSort(arr);
		System.out.println(Arrays.toString(arr)); // [-4, -1, 1, 2, 3]

		arr = new int[] {2, 3, 1, -1, -4};
		shellSort(arr);
		System.out.println(Arrays.toString(arr)); // [-4, -1, 1, 2, 3]

		System.out.println(isSorted(arr)); // true

		System.out.println(gymnasticScore(new double[] {5, 5.5, 10.0, 9.0, 3.0, 6.5})); // 6.5

		System.out.println(hottestStreak(new int[] {-1, 2, -4, 2, -1, 2, 5, -5})); // 800
		
		System.out.println(moreThanQuarter(new int[] {1, 2, 2, 6, 6, 6, 6, 7, 10})); // 6
		System.out.println(moreThanQuarter(new int[] {1, 1})); // 1

		arr = new int[] {1, 0, 2, 3, 0, 4, 5, 0};
		shiftElements(arr);
		System.out.println(Arrays.toString(arr)); // [1, 0, 0, 2, 3, 0, 0, 4]

		// arr = new int[] {2, 0, 2, 1, 1, 0, 1};
		// sortColors(arr);
		// System.out.println(Arrays.toString(arr)); // [2, 2, 0, 0, 1, 1, 1]

		System.out.println(indexOf("hello", "ll")); // 2
		System.out.println(indexOf("hello", "x")); // -1
	}

	// Problem 1
	public static int linSearch(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) return i;
		}
		return -1;
	}

	// Problem 2
	public static int binSearch(String[] arr, String key) {
		int left = 0;
		int right = arr.length;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid].compareTo(key) == 0) return mid;
			if (arr[mid].compareTo(key) < 0) left = mid + 1;
			else if (arr[mid].compareTo(key) > 0) right = mid - 1;
		}
		return -1;
	}
	// End Problem 2

	private static void swap(int[] arr, int idx1, int idx2) {
		int temp  = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

	// Problem 3
	public static void selSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIdx = i;

			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[minIdx]) minIdx = j;
			}
			swap(arr, i, minIdx);
		}
	}

	// Problem 4
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			boolean swapped = false;
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1); 
					swapped = true; 
				}
			}
			if (!swapped) break;
		}
	}

	// Problem 5
	public static void insSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int j = i;
			while (j > 0 && arr[j] < arr[j - 1]) {
				swap(arr, j--, j);
			}
		}
	}

	// Problem 6
	public static void shellSort(int[] arr) {
		int gap = arr.length / 2;

		while (gap > 0) {
			for (int i = gap; i < arr.length; i++) {
				int j = i;

				while (j >= gap && arr[j - gap] > arr[j]) {
					swap(arr, j, j - gap);
					j -= gap;
				}
			}
			gap /= 2;
		}
	}

	// Problem 7
	public static boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) return false;
		}
		return true;
	}

	// Problem 8
	public static double gymnasticScore(double[] arr) {
		if (arr.length < 0) return 0;

		double sum = 0;
		double min = arr[0]; 
		double max = arr[0];
		for (double val : arr) {
			if (val > max) max = val;
			if (val < min) min = val;
			sum += val;
		}

		return (sum - max - min) / (arr.length - 2);
	}

	// Problem 9
	public static int hottestStreak(int[] arr) {
		if (arr.length < 0) return 0;

		int max = arr[0];
		int curr = arr[0];

		for (int i = 1; i < arr.length; i++) {
			curr = Math.max(arr[i], curr + arr[i]);
			max = Math.max(max, curr);
		}

		return max;
	}

	// Problem 10
	public static int moreThanQuarter(int[] arr) {
		if (arr.length < 0) return 0;

		int count = 1;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i - 1]) count++;
			else count = 0;

			if (count > arr.length / 4.d) return arr[i];
		}
		return Integer.MIN_VALUE;
	}

	// Problem 11
	public static void shiftElements(int[] arr) {
		int nZeros = 0;
		for (int i : arr) if (i == 0) nZeros++;;;;;;;;;;;;

		for (int i = arr.length - 1; i >= 0; i--) {
			int newIdx = i + nZeros;

			if (newIdx < arr.length) arr[newIdx] = arr[i];

			if (arr[i] == 0) {
				nZeros--;
				newIdx = i + nZeros;
				if (newIdx < arr.length) arr[newIdx] = 0;
			}
		}
	}

	// Problem 12


	// Problem 13
	public static int indexOf(String str, String key) {
		for (int i = 0; i < str.length() - key.length(); i++) {
			if (str.substring(i, i + key.length()).equals(key)) return i;
		}
		return -1;
	}




















}