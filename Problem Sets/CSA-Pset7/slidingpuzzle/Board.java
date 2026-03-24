import java.util.Arrays;

public class Board {
	private int[][] board;

	public Board(int[][] tiles) {
		int[][] temp = new int[tiles.length][tiles[0].length];
		
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[0].length; j++) {
				temp[i][j] = tiles[i][j];
			}
		}

		board = temp;
	}

	public void exch(int r0, int c0, int r1, int c1) {
		int temp = board[r0][c0];
		board[r0][c0] = board[r1][c1];
		board[r1][c1] = temp;
	}

	public int[][] getBoard() {
		return board;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != 0) sb.append(board[i][j]);
				else                  sb.append(" ");
				if (j != board[0].length - 1) sb.append(" ");
			}
			sb.append("\n");
		}
		return sb.substring(0, sb.length() - 1);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		Board other = (Board) o;
		int[][] otherBoard = other.getBoard();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != otherBoard[i][j]) 
					return false;
			}
		}

		return true;
	}

	@Override
	public int hashCode() {
		return Arrays.deepHashCode(board);
	}
}