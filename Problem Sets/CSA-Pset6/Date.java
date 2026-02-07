public class Date implements Comparable<Date> {
	int D, M, Y;

	public Date(int D, int M, int Y) {
		this.D = D;
		this.M = M;
		this.Y = Y;
	}

	public int compareTo(Date other) {
		if (this.Y != other.Y) return this.Y < other.Y ? -1 : 1;
		if (this.M != other.M) return this.M < other.M ? -1 : 1;
		if (this.D != other.D) return this.D < other.D ? -1 : 1;
		return 0;
	}

	public String toString() {
		String s = String.format("Date: %02d/%02d/%02d", D, M, Y);
		return s;
	}
}