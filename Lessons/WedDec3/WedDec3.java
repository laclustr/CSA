public class WedDec3 {
	public static void main(String[] args) {
		LLArrayList<String> arr = new LLArrayList<>();

		arr.add("wsg");
		arr.add("goodbye");
		arr.add("wsg");
		arr.add("goodbye");
		arr.add("wsg");
		arr.add("goodbye");
		arr.add("wsg");
		arr.add("goodbye");
		arr.add("wsg");
		arr.add("goodbye");

		arr.remove(0);

		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println(arr.get(2));

		System.out.println(arr.size());
	}
}