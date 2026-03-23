import java.util.Set;
import java.util.HashSet;

public class Person {
	private String name;
	private int year;
	private Set<Integer> movies;

	public Person(String name, int year, Set<Integer> movies) {
		this.name = name;
		this.year = year;
		this.movies = movies;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

	public Set getMovies() {
		return movies;
	}

	public void addMovie(Integer i) {
		movies.add(i);
	}

	public String toString() {
		return "Person(name=" + name + ", year=" + year + ", movies=" + movies + ")";
	}
}