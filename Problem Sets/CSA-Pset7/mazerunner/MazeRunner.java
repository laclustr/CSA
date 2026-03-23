
public class MazeRunner {
	public static void main(String[] args) {
		if (args.length != 2 && args.length != 3) {
			System.out.println("Usage: java MazeRunner mazePath (BFS/DFS/AStar) [save]");
			System.exit(1);
		}
		if (!args[1].equals("BFS") && !args[1].equals("DFS") && !args[1].equals("AStar")) {
			System.out.println("Invalid search parameter: " + args[1]);
			System.out.println("Usage: java MazeRunner mazePath (BFS/DFS/AStar) [save]");
			System.exit(1);
		}

		String filePath = args[0];
		String typeOfSolve = args[1];
		String saveOrPrint = (args.length == 3) ? "save" : "print";

		MazeSolver ms = new MazeSolver(filePath, typeOfSolve, saveOrPrint);

		ms.solve();
	}
}