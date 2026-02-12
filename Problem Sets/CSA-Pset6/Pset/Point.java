import java.util.*;

public class Point implements Comparable<Point> {
	private int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void draw() {
		StdDraw.point(x, y);
	}

	public void drawTo(Point other) {
		StdDraw.line(this.x, this.y, other.x, other.y);
	}

	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	public int compareTo(Point other) {
		if (this.y > other.y) return 1;
		if (this.y < other.y) return -1;
		if (this.x > other.x) return 1;
		if (this.x < other.x) return -1;
		return 0;
	}

	public double slopeTo(Point other) {
		if (this.x == other.x && this.y != other.y) return Double.POSITIVE_INFINITY;
		else if (this.x == other.x && this.y == other.y) return Double.NEGATIVE_INFINITY;
		return (double) (this.y - other.y) / (this.x - other.x);
	}

	public Comparator<Point> slopeOrder() {
		return new PointComparator();
	}

	private class PointComparator implements Comparator<Point> {
		public int compare(Point p1, Point p2) {
			double slope1 = Point.this.slopeTo(p1);
			double slope2 = Point.this.slopeTo(p2);
			return Double.compare(slope1, slope2);
		}
	}
}