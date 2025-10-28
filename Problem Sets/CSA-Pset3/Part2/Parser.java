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

				String dur = line[2].trim();
				int episodeDuration = dur.equals("nan") ? 0 : Integer.parseInt(dur);

				String[] genres = line[3].split(", ");
				String[] actors = line[4].split(", ");
				double rating = Double.parseDouble(line[5].trim());
				int votes = Integer.parseInt(line[6].trim());

				String[] yrs = line[7].trim().split("-");
				int start = Integer.parseInt(yrs[0]);
				int end = yrs.length > 1 ? Integer.parseInt(yrs[1]) : Year.now().getValue();

				int[] years = new int[end - start + 1];
				for (int j = 0; j < years.length; j++) {
					years[j] = start + j;
				}

				shows[i] = new Show(title, about, episodeDuration, genres, actors, rating, votes, years);
			}

			System.out.println(Show.findShowByTitle(shows, "The Office"));

		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e);
		}
	}
}