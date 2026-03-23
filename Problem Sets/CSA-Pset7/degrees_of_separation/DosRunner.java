import java.util.*;

public class DosRunner {
	private static Map<String, Set<Integer>> names;
	private static Map<Integer, Person> people;
	private static Map<Integer, Movie>  movies;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		/* DataLoader can load either "small" or "large" dataset */
		/* Other than changing "small" to "large" you do not need to change this method */

		DataLoader dl = new DataLoader("large");
		
		names  = dl.getNames();
		people = dl.getPeople();
		movies = dl.getMovies();

		int id1 = getActorIdFromName();
		int id2 = getActorIdFromName();

		sc.close();

		degreesOfSeparation(id1, id2);
	}

	/* Prompt the user for an actor's name and return the id associated with 
		 that actor. Note that in the large file there can be more than one 
		 actor with a particular name. Display all the actors found with their 
		 birth years so the user can choose which they want.
 	*/
	public static int getActorIdFromName() {
		System.out.println("Enter Actor's Name: ");
		String name = sc.nextLine().trim().toLowerCase();

		if (!names.containsKey(name)) {
			System.out.println("Actor \"" + name + "\" not found");
			return getActorIdFromName();
		}

		Set<Integer> ids = names.get(name);

		if (ids.size() > 1) {
			System.out.println("Which \"" + name + "\"?");

			for (int id : ids) {
				Person p = people.get(id);
				System.out.println("Birth Year: " + p.getYear() + "; ID: " + id);
			}
			System.out.println("Choose person based on birth year: ");
			return Integer.parseInt(sc.nextLine().trim());
		}

		for (int i : ids) {
			return i;
		}
		return -1;
	}

	/*
		Fill in	the SearchNode class
		a search node should have a parent that is a SearchNode
		a movieId, and a personId
	 */
	private static class SearchNode {
		int personId;
		int movieId;
		SearchNode parent;

		public SearchNode(int personId, int movieId, SearchNode parent) {
			this.personId = personId;
			this.movieId = movieId;
			this.parent = parent;
		}
	}

	/*
		Prints the fewest degrees of separation in the following format:
		There are {N} degrees of separation between {Actor1Name} and {Actor2Name}.
		{Actor1Name} was in {Movie1Name} with {ActorOtherName}
		{ActorOtherName} was in {Movie2Name} with {ActorOtherOtherName}
		{ActorOtherOtherName} was in {Movie3Name} with {Actor2Name}.

		Use the SearchNode class to perform a BFS. 
	*/
	public static void degreesOfSeparation(int id1, int id2) {
		Queue<SearchNode> queue = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();

		queue.add(new SearchNode(id1, -1, null));
		visited.add(id1);

		SearchNode end = null;

		while (!queue.isEmpty()) {
			SearchNode curr = queue.remove();

			if (curr.personId == id2) {
				end = curr;
				break;
			}

			Person p = people.get(curr.personId);

			for (int movieId : p.getMovies()) {
				Movie movie = movies.get(movieId);

				for (int coStarId : movie.getPeople()) {
					if (!visited.contains(coStarId)) {
						visited.add(coStarId);
						queue.add(new SearchNode(coStarId, movieId, curr));
					}
				}
			}
		}

		if (end == null) {
			System.out.println(people.get(id1).getName() + " and " + people.get(id2).getName() + " are not connected.");
			return;
		}

		List<SearchNode> path = new ArrayList<>();

		SearchNode curr = end;

		while (curr.parent != null) {
			path.add(curr);
			curr = curr.parent;
		}

		Collections.reverse(path);

		System.out.println(
			"There are " + 
			path.size() + 
			" degrees of separation between " +
			people.get(id1).getName() + 
			" and " + 
			people.get(id2).getName() + "."
		);

		int currActorId = id1;

		for (SearchNode n : path) {
			Movie movie = movies.get(n.movieId);

			System.out.println(
				people.get(currActorId).getName() + 
				" was in " + 
				movie.getTitle() + 
				" with " + 
				people.get(n.personId).getName()
			);

			currActorId = n.personId;
		}
	}


}