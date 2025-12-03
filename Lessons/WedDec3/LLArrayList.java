public class LLArrayList<Item> {
	private class Node {
		Item data;
		Node next;

		public Node(Item data) {
			this.data = data;
		}
	}

	private int n;
	private Node front;

	public int size() {
		return n;
	}

	public void add(Item item) {
		if (front == null) {
			front = new Node(item);
		} else {
			Node curr = front;
			while (curr.next != null) {
				curr = curr.next;
			}

			curr.next = new Node(item);
		}

		n++;
	}

	public Item get(int idx) {
		if (idx >= n || idx < 0) {
			throw new ArrayIndexOutOfBoundsException("Not valid index!");
		}
		
		Node curr = front;
		for (int i = 0; i < idx; i++) curr = curr.next;

		return curr.data;
	}

	public Item remove(int idx) {
		if (idx >= n || idx < 0) {
			throw new ArrayIndexOutOfBoundsException("Not valid index!");
		}

		n--;
		
		if (idx == 0) {
			Item item = front.data;
			front = front.next;
			return item;
		}

		Node curr = front;
		for (int i = 0; i < idx - 1; i++) {
			curr = curr.next;
		}

		Item item = curr.next.data;
		curr.next = curr.next.next;

		return item;
	}























}