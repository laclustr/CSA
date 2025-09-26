import java.util.HashMap;

public class GrantVancePset2 {
	/*
	public static void main(String[] args) {
		System.out.println(minCat("Hello", "Hi"));               // "loHi"
		System.out.println(minCat("Hello", "java"));             // "ellojava"
		System.out.println(minCat("java", "Hello"));             // "javaello"

		System.out.println(countJava("aaajavabbb"));             // 1
		System.out.println(countJava("jalaxxjara"));             // 2

		System.out.println(isPalindrome("racecar"));             // true
		System.out.println(isPalindrome("mom")); 	             // true
		System.out.println(isPalindrome("number"));              // false

		System.out.println(sumString("abc1n3n4"));               // 8
		System.out.println(sumString("abc13nm4"));               // 17
		System.out.println(sumString("aba123"));                 // 123

		System.out.println(sameStarChars("xy*zzy"));             // false
		System.out.println(sameStarChars("ox*xa*az"));           // true
		System.out.println(sameStarChars("*oxox*x*"));           // true

		System.out.println(areAnagrams("listen", "silent"));     // true
		System.out.println(areAnagrams("triangle", "integral")); // true
		System.out.println(areAnagrams("hello", "world"));       // false

		System.out.println(longSubStringLen("abcabcbb"));        // 3 (abc)
		System.out.println(longSubStringLen("bbbbbb"));          // 1 (b)
		System.out.println(longSubStringLen("pwwkew"));          // 3 (kew));

		System.out.println(areRotations("abcd", "cdab"));        // true
		System.out.println(areRotations("hello", "llohe"));      // true
		System.out.println(areRotations("water", "atwar"));      // false

		System.out.println(longestWord("the quick green fox"));  // green
		System.out.println(longestWord("ap csa is easy")); 	     // easy
		System.out.println(longestWord("strings are tricky")); 	 // strings

		System.out.println(isHarshad(1000));                     // 213
		System.out.println(isHarshad(1000000));                  // 95,428

		System.out.println(sqrt(12039));                         // 109.72...
		System.out.println(sqrt(25));                            // 5.0
		System.out.println(sqrt(0.4));                           // .63245...

		System.out.println(harmonicSum(10));                     // 2.9289
		System.out.println(harmonicSum(1000));                   // 7.48547
		System.out.println(harmonicSum(10000));                  // 9.78760

		System.out.println(estimatePi());                        // something close to pi

		makeSquares(10);                                         // one solid square, one hollow square; side lengths 10

		makePyramid(4);                                          // Pyramid of height 4

		makeDiamond(3);                                          // Diamond of side length 4

		System.out.println(nEncounters());                       // some integer number!

		System.out.println(nBirthdays());                        // some integer number!
	
		System.out.println(pHasDisease(.01, .97));               // some double number!
		
		System.out.println(getTraj(20 , 5, -9.8, 65, 0.1));     // 5.494037
	}
	*/

	// Problem 1
	public static String minCat(String string1, String string2) {
		int smallest;
		if (string1.length() > string2.length()) {
			smallest = string2.length();
		} else {
			smallest = string1.length();
		}

		String shortStr1 = string1.substring(string1.length() - smallest);
		String shortStr2 = string2.substring(string2.length() - smallest);

		return shortStr1 + shortStr2;
	}

	// Problem 2
	public static int countJava(String str) {
		if (str.length() <= 3) return 0;

		int count = 0;
		for (int i = 0; i <= str.length() - 4; i++) {
			String begin = str.substring(i, i + 2);
			String end = str.substring(i + 3, i + 4);

			if (begin.equals("ja") && end.equals("a")) {
				count++;
			}
		}
		return count;
	}

	// Problem 3
	public static boolean isPalindrome(String str) {
		String revString = "";

		for (int i = str.length() - 1; i >= 0; i--) {
			revString += str.charAt(i);
		}

		return revString.equals(str);
	}

	// Problem 4
	public static int sumString(String str) {
		int total = 0;
		String currSec = "";
		for (char c : str.toCharArray()) {
			if (c >= 48 && c <= 57) {
				currSec += c;
			}
			else {
				if (!currSec.equals("")) total += Integer.valueOf(currSec);
				currSec = "";
			}
		}

		if (!currSec.equals("")) total += Integer.valueOf(currSec);

		return total;
	}

	// Problem 5
	public static boolean sameStarChars(String str) {
		for (int i = 1; i < str.length() - 1; i++) {
			if (str.charAt(i) == '*') {
				if (str.charAt(i - 1) != str.charAt(i + 1)) return false;
			}
		}
		return true;
	}

	// Problem 6
	public static boolean areAnagrams(String str1, String str2) {
		if (str1.length() != str2.length()) return false;

		HashMap<Character, Integer> counts1 = new HashMap<>();
		HashMap<Character, Integer> counts2 = new HashMap<>();

		for (char c : str1.toCharArray()) {
			if (counts1.get(c) == null) {
				counts1.put(c, 1);
			}
			else {
				counts1.put(c, counts1.get(c) + 1);
			}
		}
		for (char c : str2.toCharArray()) {
			if (counts2.get(c) == null) {
				counts2.put(c, 1);
			}
			else {
				counts2.put(c, counts2.get(c) + 1);
			}
		}

		return counts1.equals(counts2);
	}

	// Problem 7
	public static int longSubStringLen(String str) {
		int maxLen = 0;

		for (int i = 0; i < str.length(); i++) {
			String substring = "";
			for (int j = i; j < str.length(); j++) {
				char c = str.charAt(j);

				if (substring.indexOf(c) != -1) break;

				substring += c;
				if (substring.length() > maxLen) maxLen = substring.length();
			}
		}
		return maxLen;
	}

	// Problem 8
	public static boolean areRotations(String str1, String str2) {
		if (str1.length() != str2.length()) return false;

		for (int offset = 0; offset < str1.length(); offset++) {
			String rotString = "";

			for (int i = 0; i < str2.length(); i++) {
				int idx = (offset + i) % str1.length();
				rotString += str2.charAt(idx);
			}

			if (rotString.equals(str1)) return true;
		}

		return false;
	}

	// Problem 9
	public static String longestWord(String sent) {
		String longest = "";
		String curr    = "";

		for (char c : sent.toCharArray()) {
			if (c == ' ') {
				if (curr.length() >= longest.length()) {
					longest = curr;
				}
				curr = "";
			}
			else curr += c;
		}

		if (curr.length() >= longest.length()) {
			longest = curr;
		}

		return longest;
	}
	// End Problem 9

	private static boolean isHarshadHelper(int x) {
		int sum = 0;
		int kx = x;

		while (kx > 0) {
			sum += kx % 10;
			kx /= 10;
		}

		if (sum != 0) return x % sum == 0;
		return true;
	}

	// Problem 10
	public static int isHarshad(int n) {
		int count = 0;

		for (int i = 0; i < n; i++) {
			if (isHarshadHelper(i)) count++;
		}

		return count;
	}

	// Problem 11
	public static double sqrt(double num) {
		double t = num;
		double threshold = 10e-15;

		while (Math.abs(t * t - num) > threshold) {
			t = (t + num / t) / 2;
		}

		return t;
	}

	// Problem 12
	public static double harmonicSum(double num) {
		double sum = 0;

		for (int i = 1; i <= num; i++) {
			sum += 1.0 / i;
		}

		return sum;
	}

	// Problem 13
	public static double estimatePi() {
		int nTimes = 65535;
		double sum = 0.0;

		for (int i = 1; i <= nTimes; i++) {
			sum += 1.0 / (i * i);
		}

		return sqrt(6 * sum);
	}

	// Problem 14
	public static void makeSquares(int size) {
		for (int j = 0; j < size; j++) {
			for (int i = 0; i < 2 * size + 1; i++) {
				if (i - size == 0) System.out.print(" ");
				else if (
					j > 0 && j < size - 1 && 
					i < 2 * size && i > size + 1) {
					System.out.print(" ");
				}
				else System.out.print("*");
			}
			System.out.println();
		}
	}
	// End Problem 14
	
	private static String multString(String str, int times) {
		String newStr = "";

		for (int i = 0; i < times; i++) {
			newStr += str;
		}

		return newStr;
	}

	// Problem 15
	public static void makePyramid(int size) {
		for (int level = 0; level < size; level++) {
			System.out.print(multString(" ", size - level - 1));
			System.out.print(multString("*", 2 * level + 1));
			System.out.print(multString(" ", size / 2 * level) + "\n");
		}
	}

	// Problem 16
	public static void makeDiamond(int n) {
		for (int i = 1; i <= n; i++) {
			if (i == 1) {
				System.out.println(multString(" ", n - i) + "*");
			} else {
				System.out.println(multString(" ", n - i) + "*" + multString(" ", 2 * i - 3) + "*");
			}
		}

		for (int i = n - 1; i >= 1; i--) {
			if (i == 1) {
				System.out.println(multString(" ", n - i) + "*");
			} else {
				System.out.println(multString(" ", n - i) + "*" + multString(" ", 2 * i - 3) + "*");
			}
		}
	}
	// End Problem 16

	private static int randInt(int min, int max) {
		return (int) (Math.random() * (max - min)) + min;
	}

	private static int encount() {
		final int nPokemon = 150;

		int nCaught = 0;
		int nEncounters = 0;

		while (nCaught < nPokemon) {
			nEncounters++;

			int chance = randInt(0, nPokemon);

			if (chance < nPokemon - nCaught) nCaught++;
		}

		return nEncounters;
	}

	// Problem 17
	public static int nEncounters() {
		final int trials = 10000;
		int total = 0;
		for (int i = 0; i < trials; i++) {
			total += encount();
		}
		return total / trials;
	}
	// End Problem 17

	private static int birth() {
		final int nDays = 365;

		int nPeople = 0;
		int uniqueDays = 0;

		while (true) {
			nPeople++;
			int chance = randInt(0, nDays);

			if (nDays - uniqueDays > chance) uniqueDays++;
			else break;
		}
		return nPeople;
	}

	// Problem 18
	public static int nBirthdays() {
		final int trials = 10000;
		int total = 0;
        for (int i = 0; i < trials; i++) {
            total += birth();
        }
        return total / trials;
	}

	// Problem 19
	public static double pHasDisease(double x, double g) {
		final int trials = 100000;

		int positives = 0;
		int realPositives = 0;

		for (int i = 0; i < trials; i++) {
			boolean sick = Math.random() < x;

			boolean positive;

			if (sick) positive = Math.random() < g;
			else positive = Math.random() > g;

			if (positive && sick) realPositives++;
			if (positive) positives++; 
		}

		return (double) realPositives / positives;
	}

	// Problem 20
	public static double getTraj(double h, double vi, double g, double theta, double dt) {
		theta *= Math.PI / 180;

		double vx = vi * Math.cos(theta);
		double vy = vi * Math.sin(theta);

		double t = 0;

		double x = 0;
		double y = h;

		System.out.println(x + " " + y);

		while (y >= 0) {
			t += dt;
			x = vx * t;

			y = h + vy * t + 0.5 * g * t * t;

			System.out.println(x + " " + y);
		}

		return x;
	}




































}