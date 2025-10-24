import java.util.*;
import java.io.*;

public class GrantVancePset3 {
	/*
	public static void main(String[] args) {
		int[] arr;

		System.out.println(linSearch(new int[] {1, 3, 1, 2, 4}, 1));                                                                         // 0
		System.out.println(linSearch(new int[] {1, 3, 1, 2, 4}, 3));                                                                         // 1
		System.out.println(linSearch(new int[] {1, 3, 1, 2, 4}, 5));                                                                         // -1

		System.out.println(binSearch(new String[] {"apple", "banana", "lime", "yucca"}, "lime"));                                            // 2
		System.out.println(binSearch(new String[] {"apple", "banana", "lime", "yucca"}, "lemon"));                                           // -1

		arr = new int[] {2, 3, 1, -1, -4};
		selSort(arr);
		System.out.println(Arrays.toString(arr));                                                                                            // [-4, -1, 1, 2, 3]

		arr = new int[] {2, 3, 1, -1, -4};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));                                                                                            // [-4, -1, 1, 2, 3]

		arr = new int[] {2, 3, 1, -1, -4};
		insSort(arr);
		System.out.println(Arrays.toString(arr));                                                                                            // [-4, -1, 1, 2, 3]

		arr = new int[] {2, 3, 1, -1, -4};
		shellSort(arr);
		System.out.println(Arrays.toString(arr));                                                                                            // [-4, -1, 1, 2, 3]

		System.out.println(isSorted(arr));                                                                                                   // true

		System.out.println(gymnasticScore(new double[] {5, 5.5, 10.0, 9.0, 3.0, 6.5}));                                                      // 6.5

		System.out.println(hottestStreak(new int[] {-1, 2, -4, 2, -1, 2, 5, -5}));                                                           // 800
		
		System.out.println(moreThanQuarter(new int[] {1, 2, 2, 6, 6, 6, 6, 7, 10}));                                                         // 6
		System.out.println(moreThanQuarter(new int[] {1, 1}));                                                                               // 1

		arr = new int[] {1, 0, 2, 3, 0, 4, 5, 0};
		shiftElements(arr);
		System.out.println(Arrays.toString(arr));                                                                                            // [1, 0, 0, 2, 3, 0, 0, 4]

		arr = new int[] {2, 0, 2, 1, 1, 0, 1};
		sortColors(arr);
		System.out.println(Arrays.toString(arr));                                                                                            // [2, 2, 0, 0, 1, 1, 1]

		System.out.println(indexOf("hello", "ll"));                                                                                          // 2
		System.out.println(indexOf("hello", "x"));                                                                                           // -1

		System.out.println(rotatedMin(new int[] {3, 4, 5, 1, 2}));                                                                           // 1
		System.out.println(rotatedMin(new int[] {4, 5, 6, 7, 3}));                                                                           // 3

		System.out.println(minBribes(new int[] {1, 2, 3, 5, 4, 6, 7, 8}));                                                                   // 1
		System.out.println(minBribes(new int[] {4, 1, 2, 3}));                                                                               // -1
		System.out.println(minBribes(new int[] {2, 1, 5, 3, 4}));                                                                            // 3

		System.out.println(removePoms(new String[] {"red", "blue", "red", "red", "green"}, new int[] {1, 2, 3, 4, 5}));                      // 3
		System.out.println(removePoms(new String[] {"red", "red", "blue", "red", "red"}, new int[] {2, 3, 4, 5, 1}));                        // 3
		System.out.println(removePoms(new String[] {"red", "red", "blue", "blue", "green", "red", "red"}, new int[] {1, 2, 3, 4, 5, 6, 7})); // 10
		
		System.out.println(fineCalculator(2, 3, "CJ?CC?"));                                                                                  // 5
		System.out.println(fineCalculator(2, 5, "??J???"));                                                                                  // 0
		System.out.println(fineCalculator(1, 3, "C?J"));                                                                                     // 1

		prizeMoney(363);                                                                                                                     // 333 30
		prizeMoney(6666);                                                                                                                    // 3333 3333
		prizeMoney(7636);                                                                                                                    // 7333 303

		System.out.println(swapsToSave(new String[] {"S", "C", "C", "S", "S", "C"}, 6));                                                     // 2
		System.out.println(swapsToSave(new String[] {"S", "S"}, 1));                                                                         // -1
		System.out.println(swapsToSave(new String[] {"C", "S", "C", "S", "S"}, 3));                                                          // 5

		try {
			File f = new File("message.txt");
			decodeMessage(f);
			
				// Message 0:
				// Unbeknownst to Anakin, the Emperor was manipulating him from
				// the shadows. This ultimately led to Anakin's fall as a Sith
				// lord.
				// Message 1:
				// After seeing her in action, Han offered Rey a permanent
				// position as a member of his crew.
			
		} catch (FileNotFoundException e) {}
	}
	*/

	// Problem 1
	public static int linSearch(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) return i;
		}
		return -1;
	}

	// Problem 2
	public static int binSearch(String[] arr, String key) {
		int left = 0;
		int right = arr.length;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid].compareTo(key) == 0) return mid;
			if (arr[mid].compareTo(key) < 0) left = mid + 1;
			else if (arr[mid].compareTo(key) > 0) right = mid - 1;
		}
		return -1;
	}
	// End Problem 2

	private static void swap(int[] arr, int idx1, int idx2) {
		int temp  = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

	// Problem 3
	public static void selSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIdx = i;

			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[minIdx]) minIdx = j;
			}
			swap(arr, i, minIdx);
		}
	}

	// Problem 4
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			boolean swapped = false;
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1); 
					swapped = true; 
				}
			}
			if (!swapped) break;
		}
	}

	// Problem 5
	public static void insSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int j = i;
			while (j > 0 && arr[j] < arr[j - 1]) {
				swap(arr, j--, j);
			}
		}
	}

	// Problem 6
	public static void shellSort(int[] arr) {
		int gap = arr.length / 2;

		while (gap > 0) {
			for (int i = gap; i < arr.length; i++) {
				int j = i;

				while (j >= gap && arr[j - gap] > arr[j]) {
					swap(arr, j, j - gap);
					j -= gap;
				}
			}
			gap /= 2;
		}
	}

	// Problem 7
	public static boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) return false;
		}
		return true;
	}

	// Problem 8
	public static double gymnasticScore(double[] arr) {
		if (arr.length < 0) return 0;

		double sum = 0;
		double min = arr[0]; 
		double max = arr[0];
		for (double val : arr) {
			if (val > max) max = val;
			if (val < min) min = val;
			sum += val;
		}

		return (sum - max - min) / (arr.length - 2);
	}

	// Problem 9
	public static int hottestStreak(int[] arr) {
		if (arr.length < 0) return 0;

		int max = arr[0];
		int curr = arr[0];

		for (int i = 1; i < arr.length; i++) {
			curr = Math.max(arr[i], curr + arr[i]);
			max = Math.max(max, curr);
		}

		return max;
	}

	// Problem 10
	public static int moreThanQuarter(int[] arr) {
		if (arr.length < 0) return 0;

		int count = 1;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i - 1]) count++;
			else count = 0;

			if (count > arr.length / 4.d) return arr[i];
		}
		return Integer.MIN_VALUE;
	}

	// Problem 11
	public static void shiftElements(int[] arr) {
		int nZeros = 0;
		for (int i : arr) if (i == 0) nZeros++;;;;;;;;;;;;

		for (int i = arr.length - 1; i >= 0; i--) {
			int newIdx = i + nZeros;

			if (newIdx < arr.length) arr[newIdx] = arr[i];

			if (arr[i] == 0) {
				nZeros--;
				newIdx = i + nZeros;
				if (newIdx < arr.length) arr[newIdx] = 0;
			}
		}
	}

	// Problem 12
	public static void sortColors(int[] arr) {
		int low = 0;
		int mid = 0;
		int high = arr.length - 1;

		while (mid <= high) {
			if (arr[mid] == 2) {
				swap(arr, low++, mid++);
			} else if (arr[mid] == 0) mid++;
			else {
				swap(arr, mid, high--);
			}
		}
	}

	// Problem 13
	public static int indexOf(String str, String key) {
		for (int i = 0; i < str.length() - key.length(); i++) {
			if (str.substring(i, i + key.length()).equals(key)) return i;
		}
		return -1;
	}

	// Problem 14
	public static int rotatedMin(int[] arr) {
		int left = 0;
		int right = arr.length - 1;

		while (left < right) {
			int mid = (left + right) / 2;

			if (arr[mid] > arr[right]) left = mid + 1;
			else right = mid;
		}
		return arr[left];
	}

	// Problem 15
	public static int minBribes(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] - (i + 1) > 2) return -1;

			for (int j = Math.max(0, arr[i] - 2); j < i; j++) {
				if (arr[j] > arr[i]) count++;
			}
		}
		return count;
	}

	// Problem 16
	public static int removePoms(String[] poms, int[] times) {
		int time = 0;

		for (int i = 0; i < poms.length - 1; i++) {
			if (poms[i].equals(poms[i + 1])) {
				if (times[i] < times[i + 1]) time += times[i];
				else {
					time += times[i + 1];
					times[i + 1] = times[i];
				}
			}
		}
		return time;
	}

	// Problem 17
	public static int fineCalculator(int fine1, int fine2, String mural) {
		char prev = '?';
		int sum = 0;
		for (int i = 0; i < mural.length(); i++) {
			char curr = mural.charAt(i);
			if (curr == '?') continue;

			if (prev != '?' && prev != curr) {
				if (prev == 'C' && curr == 'J') sum += fine1;
				else if (prev == 'J' && curr == 'C') sum += fine2;
			}

			prev = curr;
		}
		return sum;
	}

	// Problem 18
	public static void prizeMoney(int N) {
		int first = 0;
		int second = 0;

		for (int place = 1; N > 0; place*=10) {
			int k = N % 10;
			N /= 10;
			if (k == 6) {
				first += place * 3;
				second += place * 3;
			}
			else {
				first += k * place;
			}
		}
		System.out.println(first + " " + second);
	}
	// End Problem 18

	private static void swap(String[] arr, int idx1, int idx2) {
		String temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

	private static int calcDamage(String[] instr) {
		int power = 1;
		int damage = 0;

		for (String inst : instr) {
			if (inst.equals("C")) {
				power *= 2;
			} else if (inst.equals("S")) {
				damage += power;
			}
		}
		return damage;
	}

	// Problem 19
	public static int swapsToSave(String[] instr, int field) {
		int swaps = 0;
		while (true) {
			int damage = calcDamage(instr);
			if (damage <= field) return swaps;

			int idx = -1;
			for (int i = instr.length - 2; i >= 0; i--) {
				if (instr[i].equals("C") && instr[i + 1].equals("S")) {
					idx = i;
					break;
				}
			}
			if (idx == -1) return idx;
			swap(instr, idx, idx + 1);
			swaps++;
		}
	}
	// End Problem 19

	private static void swap(Message[] arr, int idx1, int idx2) {
		Message temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

	private static void sortMsgs(Message[] msgs) {
		for (int i = 1; i < msgs.length; i++) {
			int j = i;
			while (j > 0 && msgs[j].compare(msgs[j - 1]) < 0) {
				swap(msgs, j--, j);
			}
		}
	}

	// Problem 20
	public static void decodeMessage(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);

		int lines = scanner.nextInt();
		scanner.nextLine();

		Message[] msgs = new Message[lines];

		for (int i = 0; i < lines; i++) {
			Message msg = new Message(
				scanner.nextInt(), 
				scanner.nextInt(), 
				scanner.nextLine().trim()
			);
			msgs[i] = msg;
		}

		sortMsgs(msgs);

		int prevNum = Integer.MIN_VALUE;
		for (int i = 0; i < msgs.length; i++) {
			if (msgs[i].getMessageNum() != prevNum) {
				prevNum = msgs[i].getMessageNum();
				System.out.println("Message " + msgs[i].getMessageNum() + ":");
			}
			System.out.println(msgs[i].getText());
		}
	}
}