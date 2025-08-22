import java.io.IOException;

public class App {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.err.println("Usage: java Main <image_path> <number_of_blurs>");
			return;
		}
		try {
			int[][][] img = ImageJava.loadRGB(args[0]);

			for (int time = Integer.parseInt(args[1]); time > 0; time--) {
				img = Class0001.filterBoxBlur(img);
			}

			ImageJava.showImage(img);

		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}