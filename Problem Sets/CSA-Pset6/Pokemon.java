import java.util.Comparator;

public class Pokemon {
	private String name, type;

	public Pokemon(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public static Comparator<Pokemon> pokemonNameComparator() {
		return new PokemonNameComparator();
	}

	public static Comparator<Pokemon> pokemonTypeComparator() {
		return new PokemonTypeComparator();
	}

	public static class PokemonNameComparator implements Comparator<Pokemon> {
		public int compare(Pokemon p1, Pokemon p2) {
			return p1.name.compareTo(p2.name);
		}
	}

	public static class PokemonTypeComparator implements Comparator<Pokemon> {
		public int compare(Pokemon p1, Pokemon p2) {
			return p1.type.compareTo(p2.type);
		}
	}

	public String toString() {
		return String.format("%s (%s)", name, type);
	}
}