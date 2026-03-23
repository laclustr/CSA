import java.util.Scanner;

public class ConnectFour {
	private String[][] board = new String[6][7];
	private String player;
	private String ai;
	private String currPlayer;
	private static Scanner sc = new Scanner(System.in);
	private Engine e;

	public ConnectFour(String player) {
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
			sb.append(" | ");
			for (int j = 0; j < board[0].length; j++) {
				String piece = board[i][j].equals("") ? " " : board[i][j];
				sb.append(" " + piece + " ");
				sb.append(" | ");
			}
			sb.append("\n");
		}
		for (int i = 0; i < 45; i++) sb.append("=");
		sb.append("\n");
		for (int i = 0; i < board[0].length; i++) {
			sb.append("    " + i + " ");
		}

		return sb.toString();
	}

	public void play() {
		System.out.println("\n\n");
		String winner = null;

		while (winner == null) { 
			System.out.println(currPlayer.equals(player) ? player + "'s Turn" : "Computer Thinking...");
			System.out.println(this);
			
			int c;

			if (currPlayer.equals(player)) {
				do {
					System.out.print("Enter your move: ");
					c = sc.nextInt();
				} while (!board[0][c].equals(""));
			}
			else {
				try {
					Thread.sleep(500);
				}
				catch (InterruptedException e) {
					System.out.println("You probably shouldn't be seeing this... " + e.getMessage());
				}

				c = e.getMove();
			}

			System.out.println();
			dropPiece(c);
			if (currPlayer.equals("X")) currPlayer = "O";
			else                        currPlayer = "X";

			winner = getWinner();
		}

		System.out.println(this);
		if (winner.equals("tie")) System.out.println("The game ended in a tie!");
		else                      System.out.println(winner + " wins!");
	}

	public void dropPiece(int c) {
		for (int i = board.length - 1; i >= 0; i--) {
			if (board[i][c].equals("")) {
				board[i][c] = currPlayer;
				return;
			}
		}
	}

	public String getWinner() {
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

	public static void main(String[] args) {
		System.out.println("Welcome to Connect Four! Moves are entered as the number of the row you want to drop your piece in.");
		System.out.print("1.X\n2.O\nPlay as X (1) or O (2)? ");
		int choice = sc.nextInt();

		ConnectFour game = new ConnectFour(choice == 1 ? "X" : "O");

		game.play();
		sc.close();
	}



}