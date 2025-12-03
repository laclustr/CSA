import java.util.ArrayList;

public class Runner {
	public static void main(String[] args) {
		// DArrayList arr = new DArrayList();

		GArrayList<Integer> arr = new GArrayList<Integer>();
		GArrayList<String> strArr = new GArrayList<String>();
		// same as above shorthand notation will autofill
		GArrayList<String> strAnother = new GArrayList<>();

		ArrayList<String> builtArr = new ArrayList<>();

		strArr.add("Hello");
		strArr.add("Goodbye");
		strArr.add("Snow DAy");

		builtArr.add("Snow");
		builtArr.add("Day");
		builtArr.add("Coming");


		System.out.println(strArr);
		System.out.println(builtArr);
	
		// for (int i = 0; i < 10; i++) {
		// 	arr.add((int) (Math.random()*100));		
		// }

		// System.out.println(arr);

		// while (arr.size() != 0) {
		// 	System.out.println(arr.remove(arr.size() - 1));
		// }



	}
}