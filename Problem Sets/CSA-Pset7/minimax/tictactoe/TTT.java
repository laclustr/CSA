import java.util.*;

public class TTT {
	private String[][] board = new String[3][3];
	private String player;
	private String ai;
	private String currPlayer;
	private static Scanner sc = new Scanner(System.in);
	private Engine e;

	public TTT(String player) {
		this.player = player;
		ai = player.equals("X") ? "O" : "X";
		currPlayer = "X";

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = "";
			}
		}
		e = new Engine(board, ai);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				String piece = board[i][j].equals("") ? " " : board[i][j];
				sb.append(" " + piece + " ");
				if (j != 2) sb.append(" | ");
			}
			sb.append("\n");
			if (i != 2) sb.append("---------------\n");
		}

		return sb.toString();
	}

	public void play() {
		System.out.println("\n\n");
		String winner = null;

		while (winner == null) { 
			System.out.println(currPlayer.equals(player) ? player + "'s Turn" : "Computer Thinking...");
			System.out.println(this);

			int r = 0, c = 0;

			if (currPlayer.equals(player)) {
				while (true) {
					System.out.print("Enter your move: ");
					try {
						r = sc.nextInt();
						c = sc.nextInt();
						sc.nextLine();

						if (r >= 0 && r < 3 && c >= 0 && c < 3 && board[r][c].equals("")) {
							break;
						}

						System.out.println("Invalid move. Try again.");
					}
					catch (InputMismatchException ex) {
						System.out.println("Invalid input. Enter (row) (col)");
						sc.nextLine();
					}
				}
			}
			else {
				try {
					Thread.sleep(100);
				}
				catch (InterruptedException e) {
					System.out.println("You probably shouldn't be seeing this... " + e.getMessage());
				}
				int[] rc = e.getMove();
				r = rc[0];
				c = rc[1];
			}

			System.out.println();
			board[r][c] = currPlayer;
			if (currPlayer.equals("X")) currPlayer = "O";
			else                        currPlayer = "X";

			winner = getWinner();
		}

		System.out.println(this);
		if (winner.equals("tie")) System.out.println("The game ended in a tie!");
		else                      System.out.println(winner + " wins!");
	}

	public String getWinner() {
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

	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe! Moves are entered as (row) (col). e.g. 2 1 is the middle bottom space");
		System.out.print("1.X\n2.O\nPlay as X (1) or O (2)? ");
		int choice = sc.nextInt();

		TTT game = new TTT(choice == 1 ? "X" : "O");

		game.play();
		sc.close();
	}
}