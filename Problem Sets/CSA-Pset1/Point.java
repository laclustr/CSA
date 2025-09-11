public class Point {
	private double x;
	private double y;

	public Point() {}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}

	public boolean equals(Point other) {
		return (x == other.x) && (y == other.y);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double slopeTo(Point other) {
		double dx = x - other.x;

		if (dx != 0) {
			return (y - other.y) / (dx);
		}
		return Double.POSITIVE_INFINITY;
	}

}