import java.util.Scanner;

public class TueSep16 {
	public static void main(String[] args) {
		iterThroughStr();
		monteCarlo();
		countIagos();
	}

	public static void iterThroughStr() {
		String myString = "this is my string";

		for (char myChar : myString.toCharArray()) {
			System.out.println(myChar);
		}
	}

	public static void monteCarlo() {
		int sum = 0;
		int loops = 100;
		while ((double) sum / loops < 45) {
			for (int i = 0; i < loops; i++) {
				sum += flipCoin();
			}
		}
		System.out.println((double) sum / loops);
	}

	public static int flipCoin() {
		int i = 0;
		boolean flip = Math.random() > 0.5;
		boolean prevFlip = flip;
		
		while (flip == prevFlip) {
			prevFlip = flip;
			flip = Math.random() > 0.5;

			i++;
		}
		return i;
	}

	public static void countIagos() {
		Scanner scanner = new Scanner(System.in);

		String target = "Iago".toLowerCase();
		int count = 0;

		while (scanner.hasNext()) {
			String curr = scanner.next().toLowerCase();
			if (curr.contains(target)) {
				count++;
			}
		}

		System.out.println(count);
	}
}