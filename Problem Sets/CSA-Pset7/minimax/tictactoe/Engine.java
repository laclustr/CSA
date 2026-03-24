public class Engine {
	private String[][] board;
	private String piece;
	private String opp;

	public Engine(String[][] board, String piece) {
		this.board = board;
		this.piece = piece;
		this.opp = piece.equals("O") ? "X" : "O";
	}

	/* 
	 	Replace the following code with AI
		using the minimax algorithm! 
	 */
	public int[] getMove() {
		int bestScore = Integer.MIN_VALUE;
		int[] bestMove = new int[2];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j].equals("")) {
					board[i][j] = piece;

					int score = min(Integer.MIN_VALUE, Integer.MAX_VALUE);

					board[i][j] = "";

					if (score > bestScore) {
						bestScore = score;
						bestMove = new int[]{i, j};
					}
				}
			}
		}

		return bestMove;
	}

	private int max(int a, int b) {
		String res = checkWinner();
		if (res != null) return score(res);

		int best = Integer.MIN_VALUE;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j].equals("")) {
					board[i][j] = piece;

					best = Math.max(best, min(a, b));

					board[i][j] = "";

					a = Math.max(a, best);
					if (b <= a) return best;
				}
			}
		}

		return best;
	}

	private int min(int a, int b) {
		String res = checkWinner();
		if (res != null) return score(res);

		int worst = Integer.MAX_VALUE;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j].equals("")) {
					board[i][j] = opp;

					worst = Math.min(worst, max(a, b));

					board[i][j] = "";

					b = Math.min(b, worst);
					if (b <= a) return worst;
				}
			}
		}

		return worst;
	}

	private int score(String res) {
		if (res.equals(piece)) return 1;
		if (res.equals("tie")) return 0;
		return -1;
	}

	private String checkWinner() {
		for (int i = 0; i < board[0].length; i++) {
			if (board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]) && !board[i][0].equals("")) {
				return board[i][0];
			}
		}

		for (int i = 0; i < board.length; i++) {
			if (board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i]) && !board[0][i].equals("")) {
				return board[0][i];
			}
		}

		if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].equals("")) {
			return board[0][0];
		}
		
		if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[0][2].equals("")) {
			return board[0][2];
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j].equals("")) return null;
			}
		}

		return "tie";
	}
}