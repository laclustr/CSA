import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] board = new int[n][n];

		int i = 0;
		int counter = 0;
		while (sc.hasNext()) {
			board[i][counter++] = sc.nextInt();
			if (counter == board[0].length) {
				counter = 0;
				i++;
			}
		}

		BoardSolver bs = new BoardSolver(board);
		counter = 0;
		for (Board b : bs.getSolution()) {
			System.out.println("Move " + counter++ + ":");
			System.out.println(b);
		}
	}
}