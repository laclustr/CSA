import java.util.*;
import java.io.*;

@SuppressWarnings("unchecked")
public class Day5 {
	static class Range {
		long start;
		long end;

		public Range(long start, long end) {
			this.start = start;
			this.end = end;
		}

		public String toString() {
			return "Range(" + start + ", " + end + ")";
		}

		public boolean inRange(long i) {
			return (i >= start && i <= end);
		}

		public void set(long start, long end) {
			this.start = start;
			this.end = end;
		}

		public boolean overlaps(Range other) {
			return this.start <= other.end && other.start <= this.end;
		}

		public Range merge(Range other) {
			return new Range(Math.min(other.start, this.start), Math.max(other.end, this.end));
		}

		public long getDiff() {
			return end - start + 1;
		}
	}

	public static void main(String[] args) {
		System.out.println(part1());
		System.out.println(part2());
	}

	private static ArrayList<ArrayList> parseData() {
		ArrayList<Range> ranges = new ArrayList<>();
		ArrayList<Long> ids = new ArrayList<>();

		boolean loading = true;

		try (Scanner sc = new Scanner(new File("input.txt"))) {
			while (sc.hasNext()) {
				String line = sc.nextLine();

				if (line.equals("")) {
					loading = false;
					continue;
				}

				if (loading) {
					String[] parts = line.split("-");
					long start = Long.parseLong(parts[0]);
					long end = Long.parseLong(parts[1]);

					ranges.add(new Range(start, end));
				} else {
					ids.add(Long.parseLong(line));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}

		ArrayList<ArrayList> res = new ArrayList<>();
		res.add(ranges);
		res.add(ids);

		return res;
	}

	public static long part1() {
		ArrayList<ArrayList> parsed = parseData();

		ArrayList<Range> ranges = parsed.get(0);
		ArrayList<Long> ids = parsed.get(1);

		long nFresh = 0;

		for (long id : ids) {
			for (Range range : ranges) {
				if (range.inRange(id)) {
					nFresh++;
					break;
				}
			}
		}
		return nFresh;
	}

	public static long part2() {
		ArrayList<ArrayList> parsed = parseData();

		ArrayList<Range> ranges = parsed.get(0);

		ranges.sort((a, b) -> Long.compare(a.start, b.start));

		long k = ranges.size() - 1;

		for (int i = 0; i < k; i++) {
			if (ranges.get(i).overlaps(ranges.get(i + 1))) {
				ranges.set(i, ranges.get(i).merge(ranges.get(i + 1)));
				ranges.remove(i + 1);
				k--;
				i--;
				continue;
			}
		}

		long total = 0;
		for (Range range : ranges) {
			total += range.getDiff();
		}
		return total;
	}
}