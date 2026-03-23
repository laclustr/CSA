public class Engine {
	private String[][] board;
	private String piece;

	public Engine(String[][] board, String piece) {
		this.board = board;
		this.piece = piece;
	}

	/*
		Replace the following code with AI 
		using the minimax algorithm!
	 */
	public int getMove() {
		int c;
		do {
			c = (int) (Math.random() * board[0].length);
		} while (!board[0][c].equals(""));
	
		return c;
	}
}