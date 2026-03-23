import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Maze {
	private String[][] maze;
	private String filename;

	public Maze(String filePath) {
		try {
			FileReader fr = new FileReader(filePath);
			BufferedReader br = new BufferedReader(fr);
			String line;

			line = br.readLine();
			String[] size = line.split(" ");
			int nRows = Integer.parseInt(size[0]);
			int nCols = Integer.parseInt(size[1]);

			maze = new String[nRows][nCols];

			int counter = 0;
			while ((line = br.readLine()) != null) {
				maze[counter++] = line.split("");
			}
			
			br.close();
		}
		catch (IOException e) {
			System.out.println("General I/O Problem: " + e.getMessage());
		}

		filename = getFilename(filePath);
	}

	private String getFilename(String filePath) {
		String[] split1 = filePath.split("\\\\");
		String[] split2 = filePath.split("/");

		if (split1.length > 1) {
			return split1[split1.length - 1];
		}
		else if (split2.length > 1) {
			return split2[split2.length - 1];
		}
		else {
			return filePath;
		}
	}

	public String[][] getMaze() {
		return maze;
	}

	public void setMaze(String[][] maze) {
		this.maze = maze;
	}

	public void save() {
		try {
			FileWriter fw = new FileWriter(filename + "_solved.txt");
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(this.toString());
			bw.close();
		}
		catch (IOException e) {
			System.out.println("General I/O Problem: " + e.getMessage());
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String[] row : maze) {
			sb.append(String.join("", row) + "\n");
		}

		return sb.toString();
	}
}