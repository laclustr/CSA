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
		System.out.println(sqrt(9));
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