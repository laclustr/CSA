import java.util.*;
import java.io.*;
import java.time.Year;

public class Parser {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(new File(args[0]))) {
			int nLines = scanner.nextInt();
			scanner.nextLine();

			Show[] shows = new Show[nLines];

			for (int i = 0; i < shows.length; i++) {
				String[] line = scanner.nextLine().trim().split("=");
				String title = line[0];
				String about = line[1];
				int episodeDuration = Integer.parseInt(line[2].trim());
				String[] genres = line[3].split(", ");
				String[] actors = line[4].split(", ");
				double rating = Double.parseDouble(line[5].trim());
				int votes = Integer.parseInt(line[6].trim());

				String[] yrs = line[7].trim().split("-");
				int start = Integer.parseInt(yrs[0]);
				int end;
				if (yrs.length > 1) end = Integer.parseInt(yrs[1]);
				else end = Year.now().getValue();

				int difference = end - start + 1;
				int[] years = new int[difference];
				for (int j = 0; j < difference; j++) {
					years[j] = start + j;
				}

				Show show = new Show(title, about, episodeDuration, genres, actors, rating, votes, years);
				shows[i] = show;
			}

			for (Show show : shows) {
				System.out.println(show);
			}

		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e);
		}
	}
}