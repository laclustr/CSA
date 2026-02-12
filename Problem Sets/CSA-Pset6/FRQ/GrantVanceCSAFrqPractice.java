import java.util.*;

public class GrantVanceCSAFrqPractice {
	public static void main(String[] args) {
		// int[] arr = new int[]{2, 3, 5, 1, 2, 3, 4};

		// System.out.println(longestIncreasingSequence(arr)); // 4

		// // ----------------------------------------------------------------------------
		// // ----------------------------------------------------------------------------

		// ArrayList<Integer> aList = new ArrayList<Integer>();
		// aList.add(1);
		// aList.add(2);
		// aList.add(3);
		// aList.add(4);
		// aList.add(5);
		// shiftRight(aList, 2);
		// System.out.println(aList); // [4, 5, 1, 2, 3]

		// // ----------------------------------------------------------------------------
		// // ----------------------------------------------------------------------------

		// arr = new int[]{1, 3, 3, 7};

		// System.out.println(hasAdjacentDuplicates(arr)); // true

		// arr = new int[]{1, 2, 3, 4};

		// System.out.println(hasAdjacentDuplicates(arr)); // false

		// // ----------------------------------------------------------------------------
		// // ----------------------------------------------------------------------------

		// int[][] arr2d = new int[][]{
		// 	{1, 2, 3},
		// 	{4, 5, 6},
		// 	{7, 8, 9}
		// };

		// System.out.println(Arrays.deepToString(transpose(arr2d))); // rows & cols swapped

		// // ----------------------------------------------------------------------------
		// // ----------------------------------------------------------------------------
		
		// int[][] arrMaxima = new int[][]{
		// 	{1, 2, 3, 2, 4, 8, 6, 7, 9, 2, 1, 4, 8},
		// 	{4, 5, 6, 1, 5, 2, 2, 2, 3, 4, 9, 7, 6},
		// 	{7, 8, 9, 4, 5, 2, 7, 3, 8, 3, 1, 1, 9},
		// 	{0, 1, 0, 5, 3, 7, 2, 1, 8, 2, 8, 8, 1}
		// };

		// System.out.println(countLocalMaxima(arrMaxima)); // 6

		// // ----------------------------------------------------------------------------
		// // ----------------------------------------------------------------------------
		
		// int[][] negArr = new int[][]{
		// 	{1, 2, 3, 2, 4, 8, 6, 7, 9, 2, 1, -4, 8},
		// 	{4, 5, 6, 1, 5, 2, 2, 2, 3, 4, 9, -7, 6},
		// 	{7, 8, 9, 4, 5, -2, 7, 3, 8, 3, 1, 1, 9},
		// 	{0, 1, 0, 5, 3, 7, 2, 1, 8, 2, 8, 8, 1}
		// };

		// replaceNegatives(negArr);

		// System.out.println(Arrays.deepToString(negArr));
	}

	public static int longestIncreasingSequence(int[] arr) {
		if (arr.length <= 0) return 0;

		int max = arr[0];
		int n = 1;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) n++;
			else {
				max = arr[i];
				n = 1;
			}
		}

		return n;
	}

	public static void shiftRight(ArrayList<Integer> aList, int n) {
		ArrayList<Integer> newAList = new ArrayList<>();

		n = n % aList.size();

		for (int i = 0; i < aList.size(); i++) {
			newAList.add(aList.get((aList.size() - n + i) % aList.size()));
		}

		for (int i = 0; i < aList.size(); i++) {
			aList.set(i, newAList.get(i));
		}
	}

	public static boolean hasAdjacentDuplicates(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) return true;
		}

		return false;
	}

	public static int[][] transpose(int[][] arr) {
		int[][] newT = new int[arr[0].length][arr.length];

		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr.length; j++) {
				newT[i][j] = arr[j][i];
			}
		}

		return newT;
	}

	public static int countLocalMaxima(int[][] arr) {
		int n = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				boolean greater = true;

				for (int r = -1; r <= 1; r++) {
					for (int c = -1; c <= 1; c++) {
						if (r == 0 && c == 0) continue;

						int newi = i + r;
						int newj = j + c;

						if (
							newi >= 0 && 
							newi < arr.length &&
							newj >= 0 &&
							newj < arr[0].length
						) {
							if (arr[i][j] <= arr[newi][newj]) {
								greater = false;
								
							}
						}

						if (!greater) break;

					}

					if (!greater) break;
				}

				if (greater) n++;
			}
		}

		return n;
	}

	public static void replaceNegatives(int[][] negArr) {
		int[][] cpy = new int[negArr.length][negArr[0].length];

		for (int i = 0; i < negArr.length; i++) {
			cpy[i] = Arrays.copyOf(negArr[i], negArr[i].length);
		}

		for (int i = 0; i < negArr.length; i++) {
			for (int j = 0; j < negArr[0].length; j++) {
				
				if (negArr[i][j] < 0) {
					int sum = 0;

					for (int r = -1; r <= 1; r++) {
						for (int c = -1; c <= 1; c++) {
							if (r == 0 && c == 0) continue;

							int newi = i + r;
							int newj = j + c;

							if (
								newi >= 0 && 
								newi < negArr.length &&
								newj >= 0 &&
								newj < negArr[0].length
							) {
								sum += negArr[newi][newj];
							}
						}
					}
					negArr[i][j] = sum;
				}
			}
		}
	}
}