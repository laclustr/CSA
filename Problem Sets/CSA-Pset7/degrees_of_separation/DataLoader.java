import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/*
	names  - maps names to ids
	people - maps person_ids to Person (data class with attrs name, birth, movies (set of movie_ids)  and getters)
	movies - maps movie_ids to Movie   (data class with attrs title, year, people (set of person_ids) and getters)
*/

public class DataLoader {
	private Map<String, Set<Integer>> names  = new HashMap<>();
	private Map<Integer, Person> people = new HashMap<>();
	private Map<Integer, Movie>  movies = new HashMap<>();

	private String prefix;

	public DataLoader(String prefix) {
		if (!prefix.equals("large") && !prefix.equals("small"))
			throw new Error("DataLoader Constructor only takes parameters 'large' and 'small'");

		this.prefix = prefix;
		loadData();
	}

	public void loadData() {
		try {
			System.out.println("Loading Data...");
			Scanner psc = new Scanner(new File(prefix + "/people.csv"), StandardCharsets.UTF_8);
			psc.useDelimiter(",|\n");
			psc.nextLine(); // skip header

			while (psc.hasNext()) {
				int id        = Integer.parseInt(psc.next().trim());
				String name   = psc.next().trim().replace("\"", "").toLowerCase();
				int birthYear = Integer.parseInt(psc.next().trim());

				if (!names.containsKey(name)) {
					names.put(name, new HashSet<Integer>());
				}

				names.get(name).add(id);

				people.put(id, new Person(name, birthYear, new HashSet<Integer>()));
			}
			psc.close();
		
			Scanner msc = new Scanner(new File(prefix + "/movies.csv"), StandardCharsets.UTF_8);
			msc.useDelimiter(",|\n");
			msc.nextLine();

			while (msc.hasNext()) {
				int id       = Integer.parseInt(msc.next().trim());
				String title = msc.next().trim().replace("\"", "");
				int year     = Integer.parseInt(msc.next().trim());

				movies.put(id, new Movie(title, year, new HashSet<Integer>()));
			}
			msc.close();

			Scanner ssc = new Scanner(new File(prefix + "/stars.csv"), StandardCharsets.UTF_8);
			ssc.useDelimiter(",|\n");
			ssc.nextLine();

			while (ssc.hasNext()) {
				int personId = Integer.parseInt(ssc.next().trim());
				int movieId  = Integer.parseInt(ssc.next().trim());

				// make sure the person and movie both exist
				if (people.containsKey(personId) && movies.containsKey(movieId)) {
					people.get(personId).addMovie(movieId);
					movies.get(movieId).addPerson(personId);
				}
			}
			ssc.close();

		}
		catch (FileNotFoundException e) {
			System.out.println("File Not Found: " + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("An I/O error occurred: " + e.getMessage());
		}
	}

	public Map<String, Set<Integer>> getNames() {
		return names;
	}

	public Map<Integer, Person> getPeople() {
		return people;
	}

	public Map<Integer, Movie> getMovies() {
		return movies;
	}

	public static void main(String[] args) {
		DataLoader dl = new DataLoader("small");
		dl.loadData();

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Enter the name of an actor/actress: ");
			String actorName = sc.nextLine().trim().toLowerCase();

			if (actorName.equals("exit")) break;

			if (!dl.names.containsKey(actorName)) {
				System.out.println("No actor found with the name: " + actorName);
				continue;
			}

			Set<Integer> people = dl.names.get(actorName);

			System.out.println("You found: ");
			
			for (Integer id : people) {
				System.out.println("\t" + dl.people.get(id));
			}
		}
	}
}