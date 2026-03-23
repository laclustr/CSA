import java.util.*;

public class MazeSolver {
	private Maze m;
	private String[][] maze;
	private String typeOfSolve;
	private String saveOrPrint;

	private IntPair start, end;
	private Stack<IntPair> stack;
	private Queue<IntPair> queue;
	private MaxPQ<Node> pq = new MaxPQ<>();
	private boolean[][] visited;
	private IntPair[][] parents;

	private int[][] DIRS = {{1,0}, {-1,0}, {0,1}, {0,-1}};

	public MazeSolver(String filePath, String typeOfSolve, String saveOrPrint) {
		if (!(saveOrPrint.equals("save") || saveOrPrint.equals("print")))
			throw new Error("MazeSolver constructor saveOrPrint parameter must be either save or print");
		if (!(typeOfSolve.equals("BFS") || typeOfSolve.equals("DFS") || typeOfSolve.equals("AStar")))
			throw new Error("MazeSolver constructor only takes parameters BFS, DFS, AStar");

		m = new Maze(filePath);
		maze = m.getMaze();

		this.typeOfSolve = typeOfSolve;
		this.saveOrPrint = saveOrPrint;

		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				if (maze[i][j].equals("A")) start = new IntPair(i, j);
				if (maze[i][j].equals("B")) end = new IntPair(i, j);
			}
		}

		this.reset();
	}

	public class Node implements Comparable<Node> {
		private IntPair pos;
		private int steps;
		private int manhattanDist;

		Node(IntPair pos, int steps) {
			this.pos = pos;
			this.steps = steps;
			manhattanDist = -(steps + Math.abs(pos.x - end.x) + Math.abs(pos.y - end.y));
		}

		public int compareTo(Node other) {
			if (this.manhattanDist > other.manhattanDist) return 1;
			return -1;
		}
	}

	public void save() {
		m.save();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String[] row : maze) {
			sb.append(String.join("", row) + "\n");
		}

		return sb.toString();
	}

	public void solve() {
		if (typeOfSolve.equals("BFS"))      solveBFS();
		else if (typeOfSolve.equals("DFS")) solveDFS();
		else                                solveAstar();

		if (saveOrPrint.equals("save"))
			save();
		else
			System.out.println(m);
	}

	/*
		"Solving" in the solve methods corresponds to setting the values
		in the path taken to * characters, excluding A and B
	*/

	private void reset() {
		stack = new Stack<>();
		queue = new LinkedList<>();

		visited = new boolean[maze.length][maze[0].length];
		parents = new IntPair[maze.length][maze[0].length];
		pq = new MaxPQ<>();

		queue.add(start);
		stack.add(start);
		pq.add(new Node(start, 0));

		visited[start.x][start.y] = false;
	}

	private boolean inMaze(int x, int y) {
		return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length;
	}

	private void tracePath(IntPair end) {
		IntPair curr = end;

		while (curr != null && !curr.equals(start)) {
			if (!maze[curr.x][curr.y].equals("B")) maze[curr.x][curr.y] = "*";

			curr = parents[curr.x][curr.y];
		}
	}

	private void solveSearch(boolean BFS) {
		while (!(BFS ? queue.isEmpty() : stack.isEmpty())) {
			IntPair curr = BFS ? queue.remove() : stack.pop();

			if (curr.equals(end)) break;

			for (int[] dir : DIRS) {
				int dx = curr.x + dir[0];
				int dy = curr.y + dir[1];

				if (inMaze(dx, dy) && !visited[dx][dy] && !maze[dx][dy].equals("#")) {
					visited[dx][dy] = true;
					parents[dx][dy] = curr;

					if (BFS) queue.add(new IntPair(dx, dy));
					else stack.add(new IntPair(dx, dy));
				}
			}
		}

		tracePath(end);
	}

	/* Use Breadth First Search to solve the maze from A to B */
	public void solveBFS() {
		solveSearch(true);
	}

	/* Use Depth First Search to solve the maze from A to B */
	public void solveDFS() {
		solveSearch(false);
	}

	/* Use A* Search to solve the maze from A to B */
	public void solveAstar() {
		while (!pq.isEmpty()) {
			Node currNode = pq.delMax();
			IntPair curr = currNode.pos;

			if (visited[curr.x][curr.y]) continue;

			visited[curr.x][curr.y] = true;

			if (curr.x == end.x && curr.y == end.y) break;

			for (int[] dir : DIRS) {
				int dx = curr.x + dir[0];
				int dy = curr.y + dir[1];

				if (inMaze(dx, dy) && !visited[dx][dy] && !maze[dx][dy].equals("#")) {
					parents[dx][dy] = curr;
					pq.add(new Node(new IntPair(dx, dy), currNode.steps + 1));
				}
			}
		}

		tracePath(end);
	}
}