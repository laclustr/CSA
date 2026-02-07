import java.util.*;

public class NaiveCollinearPoints {
	private ArrayList<LineSegment> segs = new ArrayList<>();

	public NaiveCollinearPoints(Point[] points) {
		ArrayList<Point> copy = new ArrayList<>(Arrays.asList(points));

		Sorting.mergesort(copy);

		for (int i = 0; i < copy.size(); i++) {
			for (int j = i + 1; j < copy.size(); j++) {
				for (int k = j + 1; k < copy.size(); k++) {
					for (int c = k + 1; c < copy.size(); c++) {
						double s1 = copy.get(i).slopeTo(copy.get(j));
						double s2 = copy.get(i).slopeTo(copy.get(k));
						double s3 = copy.get(i).slopeTo(copy.get(c));

						if (s1 == s2 && s2 == s3) {
							segs.add(new LineSegment(copy.get(i), copy.get(c)));
						}
					}
				}
			}
		}
	}

	public int numberOfSegments() {
		return segs.size();
	}

	public LineSegment[] segments() {
		return segs.toArray(new LineSegment[0]);
	}
}