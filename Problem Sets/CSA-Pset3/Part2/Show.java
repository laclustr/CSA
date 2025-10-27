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

	// public static Show findShowByTitle(String title) {

	// }

	// public static Show[] findShowsByGenre(String genre) {

	// }

	// public static Show[] findShowsByActor(String actor) {

	// }

	// public static Show[] findShowsByRelease(int year) {

	// }

	// public static void sortShowsByTitle() {

	// }

	// public static void sortShowsByRating() {

	// }

	// public static void sortShowsByYear() {

	// }

	public String toString() {
		return "Show(" + title + ", " + about + ", " + episodeDuration + ", " + Arrays.toString(years) + ")";
	}













}