import java.util.*;
import java.io.*;

public class Day8 {
	public static class Box {
		int x, y, z;

		public Box(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public double getDist(Box b) {
			return Math.abs(Math.sqrt(
				Math.pow(this.x - b.x, 2) +
				Math.pow(this.y - b.y, 2) +
				Math.pow(this.z - b.z, 2)
			));
		}

		public String toString() {
			return "Box(" + x + ", " + y + ", " + z + ")";
		}
	}

	public static class Edge {
		int a, b;
		double dist;

		public Edge(int a, int b, double dist) {
			this.a = a;
			this.b = b;
			this.dist = dist;
		}
	}

	public static void main(String[] args) {
		System.out.println(problem1("input.txt"));
	}

	private static Box[] parseData(String filePath) {
		ArrayList<Box> coords = new ArrayList<>();

		try (Scanner sc = new Scanner(new File(filePath))) {
			while (sc.hasNext()) {
				String[] data = sc.nextLine().split(",");
				int x = Integer.parseInt(data[0]);
				int y = Integer.parseInt(data[1]);
				int z = Integer.parseInt(data[2]);

				coords.add(new Box(x, y, z));
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}

		return coords.toArray(new Box[coords.size()]);
	}

	public static long problem1(String fileName) {
		Box[] coords = parseData(fileName);
		ArrayList<Edge> edges = new ArrayList<>();

		for (int i = 0; i < coords.length; i++) {
			for (int j = i + 1; j < coords.length; j++) {
				double dist = coords[i].getDist(coords[j]);
				edges.add(new Edge(i, j, dist));
			}
		}

		edges.sort(Comparator.comparingDouble(e -> e.dist));

		int[] parent = new int[coords.length];
		int[] size = new int[coords.length];

		for (int i = 0; i < coords.length; i++) {
			parent[i] = i;
			size[i] = 1;
		}

		java.util.function.IntFunction<Integer> find = x -> {
			while (x != parent[x]) {
				parent[x] = parent[parent[x]];
				x = parent[x];
			}
			return x;
		};

		int connections = 0;

		for (Edge e : edges) {
			if (connections == 1000) break;

			int pa = find.apply(e.a);
			int pb = find.apply(e.b);

			if (pa != pb) {
				parent[pb] = pa;
				size[pa] += size[pb];
			}

			connections++;
		}

		ArrayList<Integer> circuitSizes = new ArrayList<>();
		for (int i = 0; i < coords.length; i++) {
			if (parent[i] == i) {
				circuitSizes.add(size[i]);
			}
		}

		circuitSizes.sort(Collections.reverseOrder());

		long result = 1;
		for (int i = 0; i < 3; i++) {
			result *= circuitSizes.get(i);
		}

		return result;
	}




































}