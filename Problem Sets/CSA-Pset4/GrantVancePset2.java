import java.util.*;

public class GrantVancePset2 {
	public static void main(String[] args) {
		int[][] a, b;
		a = new int[][] {{1, 2}, {1, 3}};
		b = new int[][] {{4, 5}, {2, 1}};
		print2d(addMatrices(a, b));

		a = new int[][] {{1, 2}, {1, 3}};
		b = new int[][] {{4, 5}, {2, 1}};
		print2d(mulMatrices(a, b));

		a = new int[][] {{1, 2, 3}, {4, 5, 6}};
		print2d(transposeMatrix(a));

		a = new int[][] {{1, 2}, {3,4}};
		b = new int[][] {{1, 0, 0}, {0, 3, 0}, {0, 0, 10}};
		System.out.println(isDiagonal(a)); // false
		System.out.println(isDiagonal(b)); // true
	}

	private static void print2d(int[][] arr2) {
		for (int[] arr : arr2) {
			System.out.println(Arrays.toString(arr));
		}
	}

	// Problem 1
	public static int[][] addMatrices(int[][] a, int[][] b) {
		int[][] sum = new int[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				sum[i][j] = a[i][j] + b[i][j];
			}
		}
		return sum;
	}

	// Problem 2
	public static int[][] mulMatrices(int[][] a, int[][] b) {
		int[][] prod = new int[a.length][a[0].length];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				for (int c = 0; c < b.length; c++) {
					prod[i][j] += b[c][j] * a[i][c];
				}
			}
		}

		return prod;
	}

	// Problem 3
	public static int[][] transposeMatrix(int[][] a) {
		int[][] tran = new int[a[0].length][a.length];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				tran[j][i] = a[i][j];
			}
		}

		return tran;
	}

	// Problem 4
	public static boolean isDiagonal(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (i != j && a[i][j] != 0) return false;
			}
		}
		return true;
	}
	// End Problem 4

	private static int[] findCoords(int r, int c, int n) {
		return findCoords(new int[] {r, c}, n);
	}

	private static int[] findCoords(int[] ogCoords, int n) {

	}

	// Problem 5
	public static String[][] walkerPath(int n) {

	}



































}