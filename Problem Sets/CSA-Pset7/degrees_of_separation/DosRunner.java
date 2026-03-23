import java.util.Scanner;
import java.util.Map;
import java.util.Set;

public class DosRunner {
	private static Map<String, Set<Integer>> names;
	private static Map<Integer, Person> people;
	private static Map<Integer, Movie>  movies;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		/* DataLoader can load either "small" or "large" dataset */
		/* Other than changing "small" to "large" you do not need to change this method */

		DataLoader dl = new DataLoader("small");
		
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
		// your code here

		return -1;
	}

	/*
		Fill in	the SearchNode class
		a search node should have a parent that is a SearchNode
		a movieId, and a personId
	 */
	private static class SearchNode {
		// TODO: fill in this logic!
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
		// your code here.


	}


}