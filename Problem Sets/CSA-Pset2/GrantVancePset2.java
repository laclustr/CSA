import java.util.HashMap;

public class GrantVancePset2 {
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
	}

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

	public static boolean isPalindrome(String str) {
		String revString = "";

		for (int i = str.length() - 1; i >= 0; i--) {
			revString += str.charAt(i);
		}

		return revString.equals(str);
	}

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

	public static boolean sameStarChars(String str) {
		for (int i = 1; i < str.length() - 1; i++) {
			if (str.charAt(i) == '*') {
				if (str.charAt(i - 1) != str.charAt(i + 1)) return false;
			}
		}
		return true;
	}

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































}