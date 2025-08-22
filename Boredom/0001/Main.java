import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		if (args.length < 2) {
			System.err.println("Usage: java Main <image_path> <number_of_blurs> (Optional: <--save-image> <path>)");
			return;
		}
		try {
			int[][][] img = ImageJava.loadRGB(args[0]);

			for (int time = Integer.parseInt(args[1]); time > 0; time--) {
				img = Class0001.filterBoxBlur(img);
			}

			if (args.length > 3 && "--save-image".equals(args[2])) {
				try {
					ImageJava.saveImage(img, args[3]);
				} catch (IOException e) {
					System.err.println("Error: " + e.getMessage());
				}

			} else if (args.length == 3) {
				System.err.println("Usage: java Main <image_path> <number_of_blurs> (Optional: <--save-image> <path>)");
			} else {
				ImageJava.showImage(img);
			}

		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}