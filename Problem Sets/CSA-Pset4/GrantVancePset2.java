import java.util.*;

public class GrantVancePset2 {
	public static final int TRIALS = 1000000;
	public static final int SHUFFLE_AMT = 100;
	public static final int[][] DIRECTIONS = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public static final int BOARDSIZE = 4;

	public static final Map<String, Integer> DIRECTION_MAP = new HashMap<>();

	static {
    	DIRECTION_MAP.put("w", 1);
    	DIRECTION_MAP.put("a", 3);
    	DIRECTION_MAP.put("s", 0);
    	DIRECTION_MAP.put("d", 2);
	}

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

		// System.out.println(avgEscapeChance(10));

		// ticTacToe();

		// slidePuzzle();

		int[][] puzzle = {
			{5, 3, 0, 0, 7, 0, 0, 0, 0},
			{6, 0, 0, 1, 9, 5, 0, 0, 0},
			{0, 9, 8, 0, 0, 0, 0, 6, 0},

			{8, 0, 0, 0, 6, 0, 0, 0, 3},
			{4, 0, 0, 8, 0, 3, 0, 0, 1},
			{7, 0, 0, 0, 2, 0, 0, 0, 6},

			{0, 6, 0, 0, 0, 0, 2, 8, 0},
			{0, 0, 0, 4, 1, 9, 0, 0, 5},
			{0, 0, 0, 0, 8, 0, 0, 7, 9}
		};

		sudoku(puzzle);

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
		int row = row(n, c[1]);
		int col = col(n, c[0]);
		return row >= 0 && row <= 2*n && col >= 0 && col <= 2*n;
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

			if (validCount == 0) { return false;}

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

		for (int i = 0; i < 10; i++) {
			if (selfWalk(n)) total++;
		}

		return total / (float) 10;
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

	private static boolean checkTicWin(String[][] board, String player) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][0].equals(player) && 
				board[i][1].equals(player) && 
				board[i][2].equals(player)) return true;
		}

		for (int i = 0; i < board[0].length; i++) {
			if (board[0][i].equals(player) && 
				board[1][i].equals(player) && 
				board[2][i].equals(player)) return true;
		}

		if (board[0][0].equals(player) && 
			board[1][1].equals(player) && 
			board[2][2].equals(player)) return true;
		if (board[0][2].equals(player) && 
			board[1][1].equals(player) && 
			board[2][0].equals(player)) return true;

		return false;
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

		printTicBoard(board);

		while (!full(board)) {
			
			String player = (x ? "X" : "O");
			System.out.println(player + "'s turn");

			System.out.print("Enter move (row col): ");
			String[] inpt = scanner.nextLine().trim().split(" ");
			int row = Integer.parseInt(inpt[0]) - 1;
			int col = Integer.parseInt(inpt[1]) - 1;

			if (!board[row][col].equals(" ")) continue;
			else board[row][col] = player;

			printTicBoard(board);

			if (checkTicWin(board, player)) {
				System.out.println(player + " Wins!");
				break;
			}

			x = !x;
		}
	}
	// End Problem 10

	private static boolean inSlide(int[][] board, int row, int col) {
		if (row < board.length && row >= 0 && col < board[0].length && col >= 0) return true;
		return false;
	}

	private static int[][] slideBoard(int size) {
		int[][] board = new int[size][size];
		int n = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = ++n;
			}
		}
		board[size - 1][size - 1] = 0;

		return board;
	}

	private static boolean slideSolved(int[][] board) {
		int curr = 1;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (i == board.length - 1 && j == board[0].length - 1)
					return board[i][j] == 0;

				if (board[i][j] != curr) return false;

				curr++;
			}
		}
		return true;
	}

	private static int[][] getAvailDirs(int[][] board, int row, int col) {
		int[][] dirs = new int[4][2];
		int ct = 0;
		for (int[] direction : DIRECTIONS) {
			int nr = row + direction[0];
			int nc = col + direction[1];

			if (inSlide(board, nr, nc)) {
				dirs[ct++] = new int[] {nr, nc};
			}
		}
		return Arrays.copyOfRange(dirs, 0, ct);
	}

	private static int[] slideShuffle(int[][] board) {
		int zr = board.length - 1;
		int zc = board[0].length - 1;

		for (int i = 0; i < SHUFFLE_AMT; i++) {
			int[][] dirs = getAvailDirs(board, zr, zc);
			if (dirs.length == 0) continue;

			int[] coords = dirs[RNG.nextInt(dirs.length)];

			int r = coords[0];
			int c = coords[1];

			board[zr][zc] = board[r][c];
			board[r][c] = 0;

			zr = r;
			zc = c;
		}

		return new int[] {zr, zc};
	}

	// Problem 11
	public static void slidePuzzle() {
		int[][] board = slideBoard(3);

		int[] coords = slideShuffle(board);
		int r = coords[0];
		int c = coords[1];

		int n = 0;

		print2d(board);

		while (!slideSolved(board)) {
			System.out.print("Enter (wasd) to move zero: ");

			String inpt = scanner.nextLine().trim();
			int[] d = DIRECTIONS[DIRECTION_MAP.get(inpt)];
			int nr = d[0] + r;
			int nc = d[1] + c;

			if (!inSlide(board, nr, nc)) {
				System.out.println("Invalid Move!");
				continue;
			}

			board[r][c] = board[nr][nc];
			board[nr][nc] = 0;

			r = nr;
			c = nc;

			print2d(board);
			n++;
		}
		System.out.println("You Win in " + n + " moves!");
	}
	// End Problem 11

	// private static boolean has2048(int[][] board) {
	// 	for (int[] row : board) {
	// 		for (int n : row) {
	// 			if (n >= 2048) return true;
	// 		}
	// 	}
	// 	return false;
	// }

	// private static void spawnTile(int[][] board) {
	// 	int val = RNG.next() < 0.9 ? 2 : 4;
	// 	int 

	// 	while (true) {
	// 		if 
	// 	}
	// }



	// private static void printBoard(int[][] board, int score) {
	// 	System.out.println("\nScore: " + score);

	// 	for (int i = 0; i < board.length; i++) {
	// 		if (i == 0) {
	// 			System.out.println(mulStr("-", board[0].length * 3 - 2));
	// 		}
	// 		for (int j = 0; j < board[i].length; j++) {
	// 			System.out.print(board[i][j] + " ");
	// 		}
	// 		System.out.println(("|"));
	// 	}
	// 	System.out.println(mulStr("-", board[0].length * 3 - 2));
	// }

	// // Problem 12
	// public static void tw48() {
	// 	int[][] board = new int[BOARDSIZE][BOARDSIZE];

	// 	spawnTile(board);
	// 	spawnTile(board);

	// 	while (!has2048) {

	// 	}
	// }

	// End Problem 12

	private static String mulStr(String str, int n) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			sb.append(str);
		}

		return sb.toString();
	}

	private static void printSudoku(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			if (i % 3 == 0) {
				System.out.println(mulStr("-", board[0].length * 3 - 2));
			}
			for (int j = 0; j < board[i].length; j++) {
				if (j % 3 == 0) {
					System.out.print("| ");
				}
				System.out.print(board[i][j] + " ");
			}
			System.out.println(("|"));
		}
		System.out.println(mulStr("-", board[0].length * 3 - 2));
	}

	private static boolean sudokuValid(int r, int c, int v, int[][] puzzle) {
		if (r < 0 || r > puzzle.length - 1) return false;
		if (c < 0 || c > puzzle[0].length - 1) return false;
		if (v < 1 || v > 9) return false;

		return true;
	}

	private static boolean sudokuSolved(int[][] puzzle) {
		int[] sorted = {1, 2, 3, 4, 5, 6, 7, 8, 9};

		for (int[] row : puzzle) {
			int[] copy = row.clone();
			Arrays.sort(copy);
			if (!Arrays.equals(copy, sorted)) return false;
		}

		for (int col = 0; col < puzzle[0].length; col++) {
			int[] colArr = new int[puzzle.length];
			for (int row = 0; row < 9; row++) colArr[row] = puzzle[row][col];

			Arrays.sort(colArr);
			if (!Arrays.equals(colArr, sorted)) return false;
		}

		for (int row = 0; row < puzzle.length; row += 3) {
			for (int col = 0; col < puzzle[0].length; col += 3) {
				int[] block = new int[9];
				int idx = 0;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						block[idx++] = puzzle[row+i][col+j];
					}
				}
				
				Arrays.sort(block);
				if (!Arrays.equals(block, sorted)) return false;
			}
		}
		return true;
	}

	// Problem 13
	public static void sudoku(int[][] puzzle) {
		int[][] OG = new int[puzzle.length][puzzle[0].length];
		for (int i = 0; i < puzzle.length; i++) {
			OG[i] = puzzle[i].clone();
		}

		printSudoku(puzzle);

		while (!sudokuSolved(puzzle)) {
			System.out.print("Enter move (row col num): ");
			String inpt = scanner.nextLine().trim();

			String[] parts = inpt.split("\\s+");
			if (parts.length != 3) continue;

			int row = Integer.parseInt(parts[0]) - 1;
			int col = Integer.parseInt(parts[1]) - 1;
			int val = Integer.parseInt(parts[2]);

			if (!sudokuValid(row, col, val, puzzle)) continue;

			if (OG[row][col] != 0) continue;
			
			puzzle[row][col] = val;

			printSudoku(puzzle);
		}
		System.out.println("You Win!");
	}
	// End Problem 13
	





































}