import java.util.*;
import java.io.*;


public class DataAnalysis {
	private static Random rng = new Random(314159);

	public static void main(String[] args) {
		// for (int i = 0; i < 11; i++)
		// 	makeExam(24);

		String filePath = "Answers.txt";
		List<char[]> answerList = new ArrayList<>();


		try (Scanner scanner = new Scanner(new File(filePath))){
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine().trim();
				if (line.isEmpty()) continue;

				String[] tokens = line.split("\\s+");

				char[] row = new char[tokens.length];
				for (int i = 0; i < row.length; i++) {
					row[i] = tokens[i].charAt(0);
				}

				answerList.add(row);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
			return;
		}

		char[][] answers = answerList.toArray(new char[answerList.size()][]);

		for (int i = 0; i < answers.length; i++)
			System.out.println(Arrays.toString(answers[i]));
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