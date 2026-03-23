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
	public int[] getMove() {

		int r, c;
		do {
			r = (int) (Math.random() * 3);
			c = (int) (Math.random() * 3);
		} while (!board[r][c].equals(""));
		
		return new int[] {r, c};
	}
}