import java.util.*;
import java.io.*;
import java.awt.Color;

public class GrantVancePset6 {
	public static void main(String[] args) {
	// 	ArrayStack<Integer> stack = new ArrayStack<>();

	// 	stack.push(1);
	// 	stack.push(2);
	// 	stack.push(3);

	// 	for (int x : stack) {
	// 		System.out.println(x);
	// 	}

	// 	// ----------------------------------------------------------------------------
	// 	// ----------------------------------------------------------------------------

	// 	LLQueue<Integer> queue = new LLQueue<>();

	// 	queue.enqueue(1);
	// 	queue.enqueue(2);
	// 	queue.enqueue(3);

	// 	for (int x : queue) {
	// 		System.out.println(x);
	// 	}

	// 	// ----------------------------------------------------------------------------
	// 	// ----------------------------------------------------------------------------

	// 	Date[] days = {
	// 		new Date(6, 7, 2000), 
	// 		new Date(3, 4, 2000), 
	// 		new Date(1, 7, 1999), 
	// 		new Date(10, 4, 2010), 
	// 		new Date(6, 3, 2001), 
	// 		new Date(3, 4, 200)
	// 	};

	// 	Arrays.sort(days);

	// 	System.out.println(Arrays.toString(days));

	// 	// ----------------------------------------------------------------------------
	// 	// ----------------------------------------------------------------------------

	// 	ArrayList<Pokemon> pokemons = new ArrayList<>();

	// 	try (Scanner sc = new Scanner(new File("pokemon.txt"))) {
	// 		String[] parts;
	// 		sc.nextLine();
	// 		while (sc.hasNext()) {
	// 			parts = sc.nextLine().trim().split("\\s+");
	// 			pokemons.add(new Pokemon(parts[0], parts[1]));
	// 		}
	// 	} catch (FileNotFoundException e) {
	// 		System.out.println(e);
	// 	}

	// 	Collections.sort(pokemons, new Pokemon.PokemonNameComparator());
	// 	for (Pokemon p : pokemons) System.out.println(p);

	// 	Collections.shuffle(pokemons);

	// 	Collections.sort(pokemons, new Pokemon.PokemonTypeComparator());
	// 	for (Pokemon p : pokemons) 
	// 		System.out.println(p);

	// 	// ----------------------------------------------------------------------------
	// 	// ----------------------------------------------------------------------------

	// 	List<Integer> li = new ArrayList<>();

	// 	li.add(1);
	// 	li.add(7);
	// 	li.add(1);
	// 	li.add(4);
	// 	li.add(3);

	// 	Sorting.mergesort(li);
	// 	System.out.println(li);

	// 	// ----------------------------------------------------------------------------
	// 	// ----------------------------------------------------------------------------

	// 	li = new ArrayList<>();

	// 	li.add(1);
	// 	li.add(7);
	// 	li.add(1);
	// 	li.add(4);
	// 	li.add(3);

	// 	Sorting.quicksort(li);
	// 	System.out.println(li);

	// 	// ----------------------------------------------------------------------------
	// 	// ----------------------------------------------------------------------------

	// 	Sorting.sort(pokemons, new Pokemon.PokemonNameComparator(), "quicksort");
	// 	for (Pokemon p : pokemons) System.out.println(p);

	// 	Collections.shuffle(pokemons);

	// 	Sorting.sort(pokemons, new Pokemon.PokemonNameComparator(), "quicksort");
	// 	for (Pokemon p : pokemons) 
	// 		System.out.println(p);

	// 	Sorting.sort(pokemons, new Pokemon.PokemonNameComparator(), "mergesort");
	// 	for (Pokemon p : pokemons) System.out.println(p);

	// 	Collections.shuffle(pokemons);

	// 	Sorting.sort(pokemons, new Pokemon.PokemonNameComparator(), "mergesort");
	// 	for (Pokemon p : pokemons) 
	// 		System.out.println(p);

	// 	// ----------------------------------------------------------------------------
	// 	// ----------------------------------------------------------------------------

	// 	Point[] points;

	// 	try (Scanner sc = new Scanner(new File("assets-lists-of-points-for-features/input10.txt"))) {
	// 		points = new Point[Integer.parseInt(sc.nextLine().trim())];

	// 		for (int i = 0; i < points.length; i++) {
	// 			String[] tkns = sc.nextLine().trim().split("\\s+");
	// 			if (!tkns[0].equals("") && !tkns[1].equals("")) {
	// 				Point p = new Point(Integer.parseInt(tkns[0]), Integer.parseInt(tkns[1]));

	// 				points[i] = p;
	// 			}
	// 		}

	// 		NaiveCollinearPoints cp = new NaiveCollinearPoints(points);
	// 		System.out.println(cp.numberOfSegments());
	// 		System.out.println(Arrays.toString(cp.segments()));
	// 	} catch (FileNotFoundException e) {
	// 		System.out.println(e);
	// 	}

	// 	// ----------------------------------------------------------------------------
	// 	// ----------------------------------------------------------------------------

	// 	try (Scanner sc = new Scanner(new File("assets-lists-of-points-for-features/input10000.txt"))) {
	// 		points = new Point[Integer.parseInt(sc.nextLine().trim())];

	// 		for (int i = 0; i < points.length; i++) {
	// 			String[] tkns = sc.nextLine().trim().split("\\s+");
	// 			if (!tkns[0].equals("") && !tkns[1].equals("")) {
	// 				Point p = new Point(Integer.parseInt(tkns[0]), Integer.parseInt(tkns[1]));

	// 				points[i] = p;
	// 			}
	// 		}

	// 		BetterCollinearPoints bcp = new BetterCollinearPoints(points);
	// 		System.out.println(bcp.numberOfSegments());
	// 		System.out.println(Arrays.toString(bcp.segments()));

	// 		StdDraw.setXscale(0, 32768);
	// 		StdDraw.setYscale(0, 32768);
	// 		StdDraw.clear();

	// 		StdDraw.setPenRadius(0.007);
	// 		StdDraw.setPenColor(Color.BLACK);

	// 		for (LineSegment seg : bcp.segments()) {
	// 			seg.draw();
	// 		}

	// 		StdDraw.setPenRadius(0.010);
	// 		StdDraw.setPenColor(StdDraw.RED);

	// 		for (Point p : points) {
	// 			p.draw();
	// 		}

	// 	} catch (FileNotFoundException e) {
	// 		System.out.println(e);
	// 	}
	}
}