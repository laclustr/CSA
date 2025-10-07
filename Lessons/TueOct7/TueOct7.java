import java.util.Random;
import java.util.Arrays;

public class TueOct7 {
	public static void main(String[] args) {
		Random rng = new Random(67L);
		int[] arr = new int[1000];

		for (int i = 0; i < arr.length; i++) arr[i] = (int) (rng.nextDouble() * 101);

		Arrays.sort(arr);

		System.out.println(arr2str(arr));

		System.out.println(binSearch(arr, 8));
	}

	public static int linSearch(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) return i;
		}
		return -1;
	}

	public static int binSearch(int[] arr, int key) {

		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = (right + left) / 2;

			if (arr[mid] == key) return mid;

			if (arr[mid] < key) left = mid - 1;

			else if (arr[mid] > key) right = mid + 1;
		}

		return -1;
	}

	public static boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) if (arr[i + 1] < arr[i]) return false;
		return true;
	}

	public static void swap(int idx1, int idx2, int[] arr) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

	public static String arr2str(int[] arr) {
		StringBuilder res = new StringBuilder("{");

		for (int i = 0; i < arr.length; i++) {
			res.append(arr[i]);

			if (i != arr.length - 1) res.append(", ");
		}
		res.append("}");

		return res.toString();
	}
}