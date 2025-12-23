import java.util.*;

@SuppressWarnings("unchecked")
public class LLQueue<Item> {
	private Node<Item> head;
	private int n;

	public int size() {
		return n;
	}

	public void enqueue(Item obj) {
		n++;
		if (head == null) {
			head = new Node<>(obj, null);
			return;
		}

		Node<Item> curr = head;

		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = new Node<>(obj, null);
	} 

	public Item dequeue() {
		if (n == 0) return null;
		Item i = head.data;
		n--;

		head = head.next;
		return i;
	}

	public Item peek() {
		if (n == 0) return null;
		return head.data;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");

		Node<Item> curr = head;

		while (curr != null) {
			sb.append(curr.data);
			if (curr.next != null) sb.append(", ");
			curr = curr.next;
		}
		
		sb.append("]");
		return sb.toString();
	}
}