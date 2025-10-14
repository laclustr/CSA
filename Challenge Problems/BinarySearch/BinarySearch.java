import java.util.Random;
import java.util.Arrays;

public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = new int[67];
		Random rng = new Random(67L);

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (rng.nextDouble() * 101);
		}

		Arrays.sort(arr);

		// System.out.println(arr2Str(arr));
		System.out.println(findMedianSorted(new int[] {1,5,5,6,8}, new int[] {4,6,10}));
	}

	public static double findMedianSorted(int[] arr1, int[] arr2) {
		if (arr1.length < arr2.length) {
			int[] temp = arr1;
			arr1 = arr2;
			arr2 = temp;
		}

		if (arr2.length == 0) {
			if (arr1.length % 2 == 0) return (arr1[arr1.length / 2] + arr1[arr1.length / 2 + 1]) / 2.d;
			else return arr1[arr1.length / 2];
		}

		int left = 0;
		int right = arr1.length;

		while (left <= right) {
			int part1 = (left + right) / 2;
			int part2 = (arr1.length + arr2.length + 1) / 2 - part1;

			int maxL1 = (part1 == 0) ? Integer.MIN_VALUE : arr1[part1 - 1];
			int minR1 = (part1 == arr1.length) ? Integer.MAX_VALUE : arr1[part1];
			int maxL2 = (part2 == 0) ? Integer.MIN_VALUE : arr2[part2 - 1];
			int minR2 = (part2 == arr2.length) ? Integer.MAX_VALUE : arr2[part2];

			if (maxL1 <= minR2 && maxL2 <= minR1) {
				if ((arr1.length + arr2.length) % 2 == 0) return (Math.max(maxL1, maxL2) + Math.min(minR1, minR2)) / 2.d;
				else return Math.max(maxL1, maxL2);
			} else if (maxL1 > minR2) {
				right = part1 - 1;
			} else {
				left = part1 + 1;
			}
 		}
 		return 0;
	}

	public static int findMin(int[] arr) {
		int left = 0;
		int right = arr.length - 1;

		while (left < right) {
			int mid = (left + right) / 2;

			if (arr[mid] > arr[right]) left = mid + 1;
			else right = mid;
		}

		return arr[left];
	}

	public static int findShifted(int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid] == key) return mid;

			if (arr[left] <= arr[mid]) {
				if (key >= arr[left] && key < arr[mid]) right = mid - 1;
				else left = mid + 1;
			} else {
				if (key > arr[mid] && key <= arr[right]) left = mid + 1;
				else right = mid - 1;
			}
		}

		return -1;
	}

	public static int sqrt(int x) {
		int left = 0;
		int right = x;

		int mid = 0;

		while (left <= right) {
			mid = (left + right) / 2;

			int square = mid * mid;

			if (square == x) return mid;
			else if (square < x) left = mid + 1; 
			else right = mid - 1;
		}
		return right;
	}

	public static int insertOrFind(int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;

		while (left != right) {
			int mid = (left + right) / 2;

			if (arr[mid] > key) right = mid - 1;
			else if (arr[mid] < key) left = mid + 1;
			if (arr[mid] == key || left == right) return mid;
		}
		return 0;
	}

	public static int[] getBounds(int[] arr, int target) {
		int idx = binarySearch(arr, target, 0, arr.length - 1);
		int leftRes = idx;

		while (idx != -1) {
			leftRes = idx;
			idx = binarySearch(arr, target, 0, idx - 1);
		}

		idx = binarySearch(arr, target, 0, arr.length - 1);
		int rightRes = idx;

		while (idx != -1) {
			rightRes = idx;
			idx = binarySearch(arr, target, idx + 1, arr.length - 1);
		}

		return new int[]{leftRes, rightRes};
	}

	public static int binarySearch(int[] arr, int key, int left, int right) {
		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid] == key)     return mid;
			if (arr[mid] > key)      right = mid - 1;
			else if (arr[mid] < key) left = mid + 1;
		}
		return -1;
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