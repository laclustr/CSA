public class LinkedList<Item> {
	private Node head;
	private int n;

	public int size() {
		return n;
	}

	public void add(Item item) {
		Node curr = head;

		while (curr.next != null) {
			curr = curr.next;
		}

		curr.next = new Node(item);
		n++;
	}

	public Item getMiddle() {

		// FILL IN HERE
		return null;
	}

	public boolean hasCycle() {

		// FILL IN HERE
		return false;
	}

	public void reverse() {

		// MUST RUN IN PLACE
	}

	public void removeAll(Item key) {


		// FILL IN HERE
	}

	public void swapInPairs() {

		// MUST RUN IN PLACE

	}

	public static LinkedList<Integer> merge(LinkedList<Integer> li1, LinkedList<Integer> li2) {

		// FILL IN HERE

		return null;
	}

}