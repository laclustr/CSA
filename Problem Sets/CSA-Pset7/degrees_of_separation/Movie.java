import java.util.Set;

public class Movie {
	private String title;
	private int year;
	private Set<Integer> people;

	public Movie(String title, int year, Set<Integer> people) {
		this.title = title;
		this.year = year;
		this.people = people;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	public Set getPeople() {
		return people;
	}

	public void addPerson(Integer i) {
		people.add(i);
	}

	public String toString() {
		return "Movie(" + "title=" + title + ", year=" + year + ", people=" + people + ")";
	}
}