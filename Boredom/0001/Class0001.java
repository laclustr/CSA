public class Class0001 {
	public static int[][][] filterBoxBlur(int[][][] img) {
		int rows = img.length;
		int cols = img[0].length;
		int[][][] newImg = new int[rows][cols][3];

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				for (int clr = 0; clr < 3; clr++) {
					newImg[row][col][clr] = avgAdjacentPx(img, row, col, clr);
				}
			}
		}

		return newImg;
	}

	private static int avgAdjacentPx(int[][][] img, int row, int col, int clr) {
		int total = 0;
		int count = 0;

		for (int dr = -1; dr <= 1; dr++) {
			for (int dc = -1; dc <= 1; dc++) {
				int nr = dr + row;
				int nc = dc + col;

				if (nr >= 0 && nr < img.length && nc >= 0 && nc < img[0].length) {
					total += img[nr][nc][clr];
					count++;
				}
			}
		}
		return total / count;
	}
}