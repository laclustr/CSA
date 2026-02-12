/* the window by default is based on floats between (0, 0) lower left and (1, 1) upper right 
 * The canvas size is set using setCanvasSize(int width, int height) these values are in pixels
 * You draw points using the point(double x, double y) method
 * You draw lines using the line(double x1, double y1, double x2, double y2) method
 * You change the pen radius using setPenRadius(double rad)
 * You change the pen color using setPenColor(int red, int green, int blue)
 * Built in static variables for some colors are provided: BLACK, BLUE, CYAN, DARK_GRAY, GRAY, GREEN, LIGHT_GRAY, MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW, BOOK_BLUE, BOOK_LIGHT_BLUE, BOOK_RED, and PRINCETON_ORANGE
 * 
 * ANIMATIONS:
 * For the homework you can use enableDoubleBuffering() to enable animations.
 * This works by drawing your objects on a second canvas and you use the show() method to print this to the front canvas you can see
 * clear() will clear a canvas. So for animations you want to clear the offscreen canvas, 
 */

public class StdDrawExample {
	public static void main(String[] args) {
		// Uncomment to see the output.
		dumbbell();
		// circling();
	}

	public static void dumbbell() {
		StdDraw.line(0.5, 0.5, 0.75, 0.75);
		StdDraw.setPenRadius(0.025);
		StdDraw.setPenColor(StdDraw.MAGENTA);
		StdDraw.point(0.5, 0.5);
		StdDraw.point(0.75, 0.75);
	}

	public static void circling() {
	   StdDraw.setScale(-2, +2);
	   StdDraw.enableDoubleBuffering();

	   for (double t = 0.0; true; t += 0.02) {
	       double x = Math.sin(t);
	       double y = Math.cos(t);
	       StdDraw.clear();
	       StdDraw.filledCircle(x, y, 0.05);
	       StdDraw.filledCircle(-x, -y, 0.05);
	       StdDraw.show();
	       StdDraw.pause(20);
	   }
	}
}