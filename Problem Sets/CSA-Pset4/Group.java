public class Group {
	private int[][] cells;
	private char operator;
	private int target;

	public Group(int[][] cells, char operator, int target) {
		this.cells = cells;
		this.operator = operator;
		this.target = target;
	} 

	public int[][] getCells() {
		return cells;
	}

	public char getOp() {
		return operator;
	}

	public int getTarget() {
		return target;
	}
}