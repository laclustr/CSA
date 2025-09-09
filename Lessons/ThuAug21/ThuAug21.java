import java.util.Scanner;

public class ThuAug21 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Your current age: ");
		int curr_age = scanner.nextInt();

		System.out.print("Years from now: ");
		int n_years = scanner.nextInt();

		System.out.println(
			"\nYou will be " + 
			Integer.toString(n_years + curr_age) +
			" years old " + 
			Integer.toString(n_years) + 
			" years from now"
		);
	}
}