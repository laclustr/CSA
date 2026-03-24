import java.util.*;

public class BoardSolver {
	private static int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};
	/*
		Calculate the priority at the time of creation
	 */
	private class SearchNode implements Comparable<SearchNode> {
		SearchNode parent;
		Board state;
		int priority;
		int distance;
		int nSteps;
		ArrayList<Board> children;

		public SearchNode(Board state, int nSteps, SearchNode parent) {
			this.state = state;
			this.nSteps = nSteps;
			this.parent = parent;
			this.distance = manhattanDist(state);
			this.priority = this.nSteps + this.distance;
			this.children = new ArrayList<>();

			int n = state.getBoard().length;
			int er = -1;
			int ec = -1;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (state.getBoard()[i][j] == 0) {
						er = i;
						ec = j;
						break;
					}
				}
				if (ec != -1) break;
			}

			for (int[] d : DIRS) {
				int dx = er + d[0];
				int dy = ec + d[1];

				if (inBoard(dx, dy, state.getBoard().length)) {
					int[][] newBoard = Arrays.stream(state.getBoard()).map(int[]::clone).toArray(int[][]::new);

					swap(dx, dy, newBoard, er, ec);

					Board copy = new Board(newBoard);
					children.add(copy);
				}
			}
		}

		private int manhattanDist(Board b) {
			int[][] tiles = b.getBoard();
			int dist = 0;

			for (int i = 0; i < tiles.length; i++) {
				for (int j = 0; j < tiles.length; j++) {
					int val = tiles[i][j];
					if (val == 0) continue;
					int gr = (val - 1) / tiles.length;
					int gc = (val - 1) % tiles.length;
					dist += Math.abs(i - gr) + Math.abs(j - gc);
				}
			}

			return dist;
		}

		public int compareTo(SearchNode other) {
			if (this.priority < other.priority) return 1;
			return -1;
		}

		private void swap(int r, int c, int[][] arr, int nr, int nc) {
			int temp = arr[r][c];
			arr[r][c] = arr[nr][nc];
			arr[nr][nc] = temp;
		}

		private boolean inBoard(int x, int y, int n) {
			return x >= 0 && x < n && y >= 0 && y < n;
		}
	}

	private List<Board> solution;
	private MaxPQ<SearchNode> frontier = new MaxPQ<>();

	public BoardSolver(int[][] board) {
		frontier.add(new SearchNode(new Board(board), 0, null));
	}

	public List<Board> getSolution() {
		solve();
		return solution;
	}

	/* 
		Use the A* algorithm to find the 
		optimal solution to the puzzle
		set the solution attribute to the path
		of the optimal solution
	 */
	public void solve() {
		solution = new ArrayList<>();
		Set<Board> seen = new HashSet<>();

		while (!frontier.isEmpty()) {
			SearchNode curr = frontier.delMax();

			if (curr.distance == 0) {
				while (curr != null) {
					solution.add(0, curr.state);
					curr = curr.parent;
				}
				return;
			}

			seen.add(curr.state);

			for (Board child : curr.children) {
				if (!seen.contains(child)) {
					frontier.add(new SearchNode(child, curr.nSteps + 1, curr));
				}
			}
		}	
	}
}