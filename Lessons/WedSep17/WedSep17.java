import java.util.Scanner;

public class TueSep16 {
	public static void main(String[] args) {
		final int nTrials = 100000;

		longestWord();
		System.out.println("In " + nTrials + " trials, there was a " + getChance(nTrials) + "% chance.");
	}

	public static double getChance(int nTrials) {
		int sum = 0;
		for (int i = 0; i < nTrials; i++) {
			sum += event() ? 1 : 0;
		}
		return ((double) sum / nTrials) * 100;
	}

	private static boolean event() {
		int nCards  = 43;
		int nExodia = 5;

		for (int i = 0; i < 22; i++) {
			int card = (int) (Math.random() * nCards);
			nCards--;

			if (card < nExodia) nExodia--;	
			if (nExodia == 0) return true;
		}
		return false;
	}

	public static void longestWord() {
		Scanner sc = new Scanner(System.in);
		String longest = "";
		while (sc.hasNext()) {
			String curr = sc.next();

			if (curr.length() > longest.length() && 
				curr.indexOf("-") == -1 && 
				curr.indexOf("—") == -1
			) longest = curr;
		}

		System.out.println("Longest word: " + longest);
	}

}