public class Number {
	private double val;
	private static int nNums;

	public Number() {
		nNums++;
	}

	public Number(double val) {
		this.val = val;
		nNums++;
	}

	public static int getNNums() {
		return nNums;
	}

	public double getVal() {
		return val;
	}

	public String toString() {
		return new String("Number: " + val);
	}
}