import java.util.Scanner;

public class TueSep9 {
	public static void main(String[] args) {
		Number num = new Number(6.7777777);
		System.out.println(num.getVal());
		System.out.println(Number.getNNums());
		System.out.println(num);

		Integer myInteger;

		String s = "hawk";
		String s2 = "hawk";

		System.out.println(s.equals(s2));

		System.out.println((int) (Math.random() * 6) + 1);

		Scanner scanner = new Scanner(System.in);

		System.out.println(scanner.nextInt());


		scanner.close();
	}
}