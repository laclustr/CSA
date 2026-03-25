public class Engine {
	private String[][] board;
	private String piece;
	private String opp;
	private static final int DEPTH = 7;

	public Engine(String[][] board, String piece) {
		this.board = board;
		this.piece = piece;
		this.opp = piece.equals("O") ? "X" : "O";
	}

	/*
		Replace the following code with AI 
		using the minimax algorithm!
	 */
	public int getMove() {
		int bestScore = Integer.MIN_VALUE;
		int bestMove = -1;
		for (int i = 0; i < board[0].length; i++) {
			int r = getRow(i);
			if (r < 0) continue;
			board[r][i] = piece;
			int score = min(Integer.MIN_VALUE, Integer.MAX_VALUE, DEPTH - 1);
			board[r][i] = "";
			if (score > bestScore) {
				bestScore = score;
				bestMove = i;
			}
		}
		return bestMove;
	}

	private int max(int a, int b, int depth) {
		String res = checkWinner();
		if (res != null) return score(res, depth);
		if (depth == 0) return 0;
		int best = Integer.MIN_VALUE;
		for (int i = 0; i < board[0].length; i++) {
			int r = getRow(i);
			if (r < 0) continue;
			board[r][i] = piece;
			int score = min(a, b, depth - 1);
			board[r][i] = "";
			best = Math.max(best, score);
			a = Math.max(a, best);
			if (b <= a) break;
		}
		return best;
	}

	private int min(int a, int b, int depth) {
		String res = checkWinner();
		if (res != null) return score(res, depth);
		if (depth == 0) return 0;
		int worst = Integer.MAX_VALUE;
		for (int i = 0; i < board[0].length; i++) {
			int r = getRow(i);
			if (r < 0) continue;
			board[r][i] = opp;
			int score = max(a, b, depth - 1);
			board[r][i] = "";
			worst = Math.min(worst, score);
			b = Math.min(b, worst);
			if (b <= a) break;
		}
		return worst;
	}

	private int getRow(int c) {
		for (int r = board.length - 1; r >= 0; r--) 
			if (board[r][c].equals("")) return r;
		return -1;
	}

	private int score(String res, int depth) {
		if (res.equals(piece)) return DEPTH + depth;
		if (res.equals("tie")) return 0;
		return -(DEPTH + depth);
	}

	private String checkWinner() {
		// check horizontal
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length - 3; j++) {
				if (
					board[i][j].equals(board[i][j + 1]) &&
					board[i][j].equals(board[i][j + 2]) &&
					board[i][j].equals(board[i][j + 3]) &&
					!board[i][j].equals("")
					) return board[i][j];
			}
		}

		// check vert
		for (int j = 0; j < board[0].length; j++) {
			for (int i = 0; i < board.length - 3; i++) {
				if (
					board[i][j].equals(board[i + 1][j]) &&
					board[i][j].equals(board[i + 2][j]) &&
					board[i][j].equals(board[i + 3][j]) &&
					!board[i][j].equals("")
					) return board[i][j];
			}
		}

		// check diagonal (bottom-left to top-right)
		for (int i = 3; i < board.length; i++) {
			for (int j = 0; j < board[0].length - 3; j++) {
				if (
					board[i][j].equals(board[i - 1][j + 1]) &&
					board[i][j].equals(board[i - 2][j + 2]) &&
					board[i][j].equals(board[i - 3][j + 3]) &&
					!board[i][j].equals("")
					) return board[i][j];
			}
		}

		// check diagonal (top-left to bottom-right)
		for (int i = 0; i < board.length - 3; i++) {
			for (int j = 0; j < board[0].length - 3; j++) {
				if (
					board[i][j].equals(board[i + 1][j + 1]) &&
					board[i][j].equals(board[i + 2][j + 2]) &&
					board[i][j].equals(board[i + 3][j + 3]) &&
					!board[i][j].equals("")
					) return board[i][j];	
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j].equals("")) return null;
			}
		}

		return "tie";
	}
}