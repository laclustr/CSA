import java.util.*;
import java.io.*;


public class DataAnalysis {
	private static Random rng = new Random(314159);

	public static void main(String[] args) {

		// int x = 5, y = 0;

		try {
			Scanner sc = new Scanner(new File("aisdjfafds.csv"));
		}		
		catch (FileNotFoundException e) {
			System.out.println(e);
		}

		// try {
		// 	System.out.println(x / y);
		// }
		// catch (ArithmeticException ae) {
		// 	System.out.println("there was a problem!");
		// }

		// System.out.println("Done");

	}

	public static void makeExam(int N) {
		char[] choices = {'a', 'b', 'c', 'd'};

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			sb.append(choices[(int)(rng.nextDouble() * 4)]);
			if (i != N - 1) sb.append(" ");
		}

		System.out.println(sb);
	}
}