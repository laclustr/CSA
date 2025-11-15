import java.util.*;

public class GrantVancePset2 {
	public static final int TRIALS = 1000000;
	public static final int[][] DIRECTIONS = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public static final Random RNG = new Random();
	public static final Scanner scanner = new Scanner(System.in);

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

		// print2d(walkerPath(5));

		// System.out.println(avgEscapeSteps(10));

		// System.out.println(avgVisitSteps(10));

		// print2d(deadWalk(5));

		System.out.println(avgEscapeChance(10));

		// ticTacToe();
	}

	private static void print2d(int[][] arr2) {
		for (int[] arr : arr2) {
			System.out.println(Arrays.toString(arr));
		}
	}

	private static void print2d(String[][] arr2) {
		for (String[] arr : arr2) {
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
		int[][] prod = new int[a.length][b[0].length];

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

	private static String[][] grid(int n) {
		String[][] grid = new String[2 * n + 1][2 * n + 1];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = " ";
			}
		}

		return grid;
	}

	private static int row(int n, int y) { return n - y; }
	private static int col(int n, int x) { return x + n; }

	private static int[] randDir() {
		return DIRECTIONS[RNG.nextInt(DIRECTIONS.length)];
	}

	private static boolean inGrid(int[] c, int n) {
		return c[0] >= -n && c[0] <= n && c[1] >= -n && c[1] <= n;
	}

	private static int[] add(int[] a, int[] b) {
		return new int[]{ a[0] + b[0], a[1] + b[1] };
	}

	private static int[] addIP(int[] a, int[] b) {
		for (int i = 0; i < b.length; i++) a[i] += b[i];
		return a;
	}

	// Problem 5
	public static String[][] walkerPath(int n) {
		String[][] grid = grid(n);

		int[] coords = new int[] {0, 0};

		int row = n;
		int col = n;

		while (inGrid(coords, n)) {
			grid[row(n, coords[1])][col(n, coords[0])] = "#";

			int direct[] = randDir();

			addIP(coords, direct);
		}

		return grid;
	}
	// End Problem 5

	private static int escape(int n) {
		int count = 0;

		int[] coords = new int[] {0, 0};

		while (inGrid(coords, n)) {
			int[] direct = randDir();

			addIP(coords, direct);
			count++;
		}

		return count;
	}

	// Problem 6
	public static double avgEscapeSteps(int n) {
		long total = 0;

		for (int i = 0; i < TRIALS; i++) total += escape(n);

		return total / (float) TRIALS;
	}
	// End Problem 6

	private static boolean visited(String[][] arr) {
		for (String[] ar : arr) {
			for (String a : ar) {
				if (a.equals(" ")) return false;
			}
		}

		return true;
	}

	private static int visit(int n) {
		String[][] grid = grid(n);
		int[] coords = new int[] {0, 0};

		int count = 0;

		while (!visited(grid)) {
			grid[row(n, coords[1])][col(n, coords[0])] = "#";

			int[] direct = randDir();

			int[] newCoords = add(coords, direct);

			if (inGrid(newCoords, n)) {
				coords = newCoords;
			}

			count++;
		}

		return count;
	}

	// Problem 7
	public static double avgVisitSteps(int n) {
		long total = 0;

		for (int i = 0; i < TRIALS; i++) total += visit(n);

		return total / (float) TRIALS;
	}
	// End Problem 7

	private static boolean checkTrapped(String[][] grid, int[] coords, int n) {
		for (int[] direction : DIRECTIONS) {
			int[] newCoords = add(coords, direction);

			if (inGrid(newCoords, n)) {
				if (grid[row(n, newCoords[1])][col(n, newCoords[0])].equals(" ")) {
					return false;
				}
			}
		}

		return true;
	}

	// Problem 8
	public static String[][] deadWalk(int n) {
		String[][] grid = grid(n);

		int[] coords = new int[] {0, 0};

		while (inGrid(coords, n)) {
			grid[row(n, coords[1])][col(n, coords[0])] = "#";
			if (checkTrapped(grid, coords, n)) break;

			while (true) {
				int[] direction = randDir();
				int[] newCoords = add(coords, direction);

				if (inGrid(newCoords, n)) {
					if (grid[row(n, newCoords[1])][col(n, newCoords[0])].equals(" ")) {
						coords = newCoords;
						break;
					}
				}
			}
		}

		return grid;
	}
	// End Problem 8

	private static boolean selfWalk(int n) {
		String[][] grid = grid(n);

		int[] coords = new int[] {0, 0};
		grid[row(n, coords[1])][col(n, coords[0])] = "#";

		while (inGrid(coords, n)) {
			int validCount = 0;
			int[][] validDirections = new int[DIRECTIONS.length][2];

			for (int[] direction : DIRECTIONS) {
				int[] newCoords = add(coords, direction);

				if (inGrid(newCoords, n)) {
					if (grid[row(n, newCoords[1])][col(n, newCoords[0])].equals(" ")) {
						validDirections[validCount] = Arrays.copyOf(direction, direction.length);
						validCount++;
					}
				}
			}

			if (validCount == 0) return false;

			int[] direction = validDirections[RNG.nextInt(validCount)];
			addIP(coords, direction);

			if (inGrid(coords, n)) {
				grid[row(n, coords[1])][col(n, coords[0])] = "#";
			}
		}
		return true;
	}

	// Problem 9
	public static double avgEscapeChance(int n) {
		long total = 0;

		for (int i = 0; i < TRIALS; i++) {
			if (selfWalk(n)) total++;
		}

		return total / (float) TRIALS;
	}
	// End Problem 9

	private static boolean full(String[][] board) {
		for (String[] s : board) {
			for (String str : s) {
				if (str.equals(" ")) return false;
			}
		}
		return true;
	}

	private static void printTicBoard(String[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length - 1; j++) {
				System.out.print(board[i][j] + "|");
			}
			System.out.println(board[i][board[i].length - 1]);
			if (i < board.length - 1) System.out.println("_____");
		}
	}

	// Problem 10
	public static void ticTacToe() {
		String[][] board = 
		{
			{" ", " ", " "},
			{" ", " ", " "},
			{" ", " ", " "}
		};

		boolean x = true;

		while (!full(board)) {
			printTicBoard(board);
			
			String player = (x ? "X" : "O");
			System.out.println(player + "'s turn");

			System.out.print("Enter move (row col): ");
			String inpt = scanner.nextLine();

			int[] coords = {0};
			break;
		}


	}





































}