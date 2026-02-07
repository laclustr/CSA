public class LineSegment {
	private Point p1;
	private Point p2;

	public LineSegment(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public void draw() {
		p1.drawTo(p2);
	}

	public String toString() {
		return p1 + " -> " + p2;
	}
}