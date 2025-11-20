public class Crossword {
	private Square[][] puzzle;

	public Crossword(boolean[][] blackSquares) {
		puzzle = new Square[blackSquares.length][blackSquares[0].length];

		int label = 1;

		for (int r = 0; r < blackSquares.length; r++) {
			for (int c = 0; c < blackSquares[0].length; c++) {
				boolean toLabel = toBeLabeled(r, c, blackSquares);
				if (!blackSquares[r][c]) puzzle[r][c] = new Square(false, toLabel ? label++ : 0);
				else puzzle[r][c] = new Square(true, 0);
			}
		}
	}

	private boolean toBeLabeled(int r, int c, boolean[][] blackSquares) {
		if (blackSquares[r][c]) return false;
		return (
			r == 0 ||
			blackSquares[r - 1][c] ||
			c == 0 ||
			blackSquares[r][c - 1]
		);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Square[] row : puzzle) {
			sb.append("-".repeat(puzzle[0].length * 2 + 1));
			sb.append("\n");

			sb.append("|");
			for (Square s : row) {
				sb.append(s.toString());
				sb.append("|");
			}
			sb.append("\n");
		}
		sb.append("-".repeat(puzzle[0].length * 2 + 1));
		return sb.toString();
	}
}
