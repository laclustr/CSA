/*
	A Hashable pair of integers.
	
	Public attributes for ease of mutating
	and accessing the values in the pair
*/

import java.util.Arrays;

public class IntPair {
	public int x, y;

	/* make pair (0, 0) */
	public IntPair() 
	{}

	public IntPair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	@Override
	public int hashCode() {
		return Arrays.hashCode(new int[] {x, y});
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;

		IntPair other = (IntPair) o;
		return (this.x == other.x) && (this.y == other.y);
	}
}