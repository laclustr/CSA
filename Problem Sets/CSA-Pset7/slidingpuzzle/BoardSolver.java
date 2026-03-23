import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;


public class BoardSolver {

	/*
		Calculate the priority at the time of creation
	 */
	private class SearchNode {
		SearchNode parent;
		Board state;
		int priority;
		int distance;
		int nSteps;
		ArrayList<Board> children;

		public SearchNode(Board state, int nSteps, SearchNode parent) {
			// TODO! Fill in the logic here.
		}
	}

	private List<Board> solution;
	private PriorityQueue<SearchNode> frontier = new PriorityQueue<>();

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

	}
}