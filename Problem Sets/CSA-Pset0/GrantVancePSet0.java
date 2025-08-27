public class GrantVancePSet0 {
	// Problem 1
	public static int sumDouble(int a, int b) {
		if (a == b) {
			return 4 * a;
		}
		return a + b;
	}

	// Problem 2
	public static boolean inRange(int a, int b) {
		return (((a <= 30 && a >= 20) && (b <= 30 && b >= 20)) || ((a <= 100 && a >= 90) && (b <= 100 && b >= 90)));
	}

	// Problem 3
	public static int absolute(int x) {
		if (x < 0) x *= -1;
		return x;
	}

	// Problem 4
	public static int closeNum(int a, int b) {
		int adist = absolute(10 - a);
		int bdist = absolute(10 - b);
		if (adist == bdist) {
			return 0;
		}

		return Math.min(adist, bdist) == adist ? a : b;
	}

	// Problem 5
	public static boolean isHarshad(int x) {
		int sum = 0;
		int kx = x;

		while (kx > 0) {
			sum += kx % 10;
			kx /= 10;
		}

		return x % sum == 0;
	}

	// Problem 6
	public static void leastToGreatest(int x, int y, int z) {
		if (x > y) {
			int temp = x;
			x = y;
			y = temp;
		}
		if (y > z) {
			int temp = y;
			y = z;
			z = temp;
		}
		if (x > y) {
			int temp = x;
			x = y;
			y = temp;
		}
			
		System.out.println("Ascending order: " + x + ", " + y + ", " + z);
	}

	// Problem 7
	public static int roundNum(double d) {
		int dInt = (int) d;

		if ((int) (d * 10) % 10 >= 5 ) {
			return dInt + 1;
		}
		return dInt;
	}

	// Problem 8
	public static boolean twinTrouble(boolean one, boolean two) {
		return one == two;
	}

	// Problem 9
	public static void quadRoots(double a, double b, double c) {
		double discriminant = Math.sqrt(b * b - 4 * a * c);
		if (Double.isNaN(discriminant)) {
			System.out.println("No real roots!");
		} else {

			double root1 = (-b + discriminant) / (2 * a);
			double root2 = (-b - discriminant) / (2 * a);

			if (root1 == root2) {
				System.out.println("Double root: x = " + root1);
			} else {
				System.out.println("Root 1: x = " + root1 + ", Root 2: x = " + root2);
			}
		}
	}

	// Problem 10
	public static double calcForce(double m1, double m2, double r) {
		return (6.67 * Math.pow(10, -11) * m1 * m2) / (r * r);
	}

	// Problem 11
	public static double baryCenter(double m1, double m2, double a) {
		return (a * m2) / (m1 + m2);
	}

	// Problem 12
	public static double yPosition(double vel, double t) {
		return (0.5 * -9.8 * (t * t)) + (vel * t) + (0);
	}

	// Problem 13
	public static double triArea(double a, double b, double c) {
		if (a + b <= c || b + c <= a || a + c <= b) {
			return -1;
		}

		double s = (a + b + c) / 2;

		return Math.sqrt(s * (s - a) * (s - b) * (s - c));
	}

	// Problem 14
	public static double calcLJ(double eps, double sig, double r) {
		return (48 * eps / (r * r)) * (Math.pow(sig / r, 12) - 0.5 * Math.pow(sig / r, 6));
	}
}