public class TueSep30 {
	public static void main(String[] args) {
		int[] arr = new int[5];
		int[] ar2 = new int[5];
		int[] arr3 = {1, 2, 3, 4, 5, 6, 7};

		System.out.println(arr.length + " " + arr3.length);
		System.out.println(arr3[1]);

		for (int i = 0; i < arr.length; i++) {
			if (arr2[i] != arr[i]) System.out.println(false); 
		}
	}
}