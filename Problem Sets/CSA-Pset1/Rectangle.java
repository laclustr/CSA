public class Rectangle {
	private Point topLeft;
	private Point topRight;
	private Point bottomLeft;
	private Point bottomRight;

	public Rectangle(
		Point topLeft, 
		Point topRight, 
		Point bottomLeft, 
		Point bottomRight
	) {
		this.topLeft = topLeft;
		this.topRight = topRight;
		this.bottomLeft = bottomLeft;
		this.bottomRight = bottomRight;
	}

	public String toString() {
		return "(" + 
		topLeft + "," + 
		topRight + "," + 
		bottomLeft + "," + 
		bottomRight + 
		")";
	}

	public boolean equals(Rectangle other) {
		return
		this.topLeft.equals(other.topLeft) &&
		this.topRight.equals(other.topRight) &&
		this.bottomLeft.equals(other.bottomLeft) &&
		this.bottomRight.equals(other.bottomRight);
	}

	public boolean isOverlapping(Rectangle other) {
		if (!this.isValid() || !other.isValid()) {
			return false;
		}

		if (this.topRight.getX() < other.topLeft.getX() || this.topLeft.getX() > other.topRight.getX()) {
			return false;
		}

		if (this.bottomLeft.getY() > other.topLeft.getY() || other.bottomLeft.getY() > this.topLeft.getY()){
			return false;
		}

		return true;
	}

	public double getArea() {
		double btm = bottomLeft.getX() - bottomRight.getX();
		double top = topLeft.getY() - bottomLeft.getY();
		return Math.abs(btm * top);
	}

	public boolean isSquare() {
		return bottomLeft.slopeTo(topRight) == -topLeft.slopeTo(bottomRight);
	}

	public boolean isValid() {
		boolean sides = topLeft.getX() == bottomLeft.getX() && topRight.getX() == bottomRight.getX();
		boolean tops = topLeft.getY() == topRight.getY() && bottomLeft.getY() == bottomRight.getY();
		return sides && tops;
	}





























}