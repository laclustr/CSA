import java.util.*;

public class BetterCollinearPoints {
	private ArrayList<LineSegment> segs = new ArrayList<>();

	public BetterCollinearPoints(Point[] points) {
		ArrayList<Point> copy = new ArrayList<>(Arrays.asList(points));

		Sorting.mergesort(copy);

		for (int i = 0; i < copy.size(); i++) {
			Point origin = copy.get(i);

			ArrayList<Point> others = new ArrayList<>(copy);
			Sorting.mergesort(others, origin.slopeOrder());

			int c = 1;
			double prevS = origin.slopeTo(others.get(0));

			for (int j = 1; j < copy.size(); j++) {
				double slope = origin.slopeTo(others.get(j));

				if (Double.compare(slope, prevS) == 0) {
					c++;
				} else {
					if (c >= 3) {
						addSeg(origin, others, j - c, j);
					}
					c = 1;
					prevS = slope;
				}
			}

			if (c >= 3) {
				addSeg(origin, others, others.size() - c, others.size());
			}
		}
	}

	private void addSeg(Point origin, ArrayList<Point> points, int start, int end) {
		Point min = origin;
		Point max = origin;

		for (int i = start; i < end; i++) {
			if (points.get(i).compareTo(min) < 0) min = points.get(i);
			if (points.get(i).compareTo(max) > 0) max = points.get(i);
		}

		if (origin.compareTo(min) == 0) {
			segs.add(new LineSegment(min, max));
		}
	}

	public int numberOfSegments() {
		return segs.size();
	}

	public LineSegment[] segments() {
		return segs.toArray(new LineSegment[0]);
	}
}