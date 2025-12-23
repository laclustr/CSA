import java.util.*;

@SuppressWarnings("unchecked")
public class LLRandomizedQueue<Item> {
	private Node<Item> head;
	private int n;
	private Random RNG = new Random();

	public int size() {
		return n;
	}

	public void enqueue(Item obj) {
		n++;
		if (head == null) {
			head = new Node(obj, null);
			return;
		}

		Node curr = head;

		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = new Node(obj, null);
	} 

	public Item dequeue() {
		if (n == 0) return null;
		int idx = RNG.nextInt(n);

		if (idx == 0) {
			Item i = head.data;
			head = head.next;
			n--;
			return i;
		}

		Node<Item> curr = head;
		for (int i = 0; i < idx - 1; i++) {
			curr = curr.next;
		}

		Item d = curr.next.data;

		curr.next = curr.next.next;

		n--;

		return d;
	}

	public Item sample() {
		if (n == 0) return null;

		int idx = RNG.nextInt(n);

		Node<Item> curr = head;
		for (int i = 0; i < idx; i++) {
			curr = curr.next;
		}

		return curr.data;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");

		Node curr = head;

		while (curr != null) {
			sb.append(curr.data);
			if (curr.next != null) sb.append(", ");
			curr = curr.next;
		}
		
		sb.append("]");
		return sb.toString();
	}
}