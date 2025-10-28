import java.util.Arrays;

public class Show {
	private String title;
	private String about;
	private int episodeDuration;
	private String[] genres;
	private String[] actors;
	private double rating;
	private int votes;
	private int[] years;

	public Show(
		String title, 
		String about, 
		int episodeDuration, 
		String[] genres, 
		String[] actors, 
		double rating, 
		int votes, 
		int[] years
	) {
		this.title = title;
		this.about = about;
		this.episodeDuration = episodeDuration;
		this.genres = genres;
		this.actors = actors;
		this.rating = rating;
		this.votes = votes;
		this.years = years;
	}

	public String getTitle() {
		return title;
	}

	public String[] getGenres() {
		return genres;
	}

	public String[] getActors() {
		return actors;
	}

	public int[] getYears() {
		return years;
	}

	public String toString() {
		return "Show(" + title + ", " + about + ", " + episodeDuration + ", " + Arrays.toString(years) + ")";
	}

	public static Show findShowByTitle(Show[] shows, String title) {
		for (Show show : shows) 
			if (show.getTitle().equals(title)) return show;
		return null;
	}

	public static Show[] findShowsByGenre(Show[] shows, String genre) {
		int count = 0;
		for (Show show : shows) {
			for (String sGenre : show.getGenres()) {
				if (sGenre.equals(genre)) {
					count++;
					break;
				}
			}
		}

		Show[] matchingShows = new Show[count];

		int idx = 0;
		for (Show show : shows) {
			for (String sGenre : show.getGenres()) {
				if (sGenre.equals(genre)) {
					matchingShows[idx++] = show;
					break;
				}
			}
		}

		return matchingShows;
	}

	public static Show[] findShowsByActor(Show[] shows, String actor) {
		int count = 0;
		for (Show show : shows) {
			for (String sActor : show.getActors()) {
				if (sActor.equals(actor)) {
					count++;
					break;
				}
			}
		}

		Show[] matchingShows = new Show[count];

		int idx = 0;
		for (Show show : shows) {
			for (String sActor : show.getActors()) {
				if (sActor.equals(actor)) {
					matchingShows[idx++] = show;
					break;
				}
			}
		}
		return matchingShows;
	}

	public static Show[] findShowsByRelease(Show[] shows, int year) {
		int count = 0;
		for (Show show : shows) {
			for (int sYear : show.getYears()) {
				if (sYear == year) {
					count++;
					break;
				}
			}
		}

		Show[] matchingShows = new Show[count];

		int idx = 0;
		for (Show show : shows) {
			for (int sYear : show.getYears()) {
				if (sYear == year) {
					matchingShows[idx++] = show;
					break;
				}
			}
		}
		return matchingShows;
	}

	private static void swap(Show[] shows, int idx1, int idx2) {
		Show temp = shows[idx1];
		shows[idx1] = shows[idx2];
		shows[idx2] = temp;
	}

	// public static void sortShowsByTitle() {

	// }

	// public static void sortShowsByRating() {

	// }

	// public static void sortShowsByYear() {

	// }
}