import java.util.*;

@SuppressWarnings("unchecked")
public class LLQueue {
	private Node head;
	private int n;

	public class Node {
		Item data;
		Node next;

		Node(Item data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	public int size() {
		return n;
	}

	public void enqueue(Item obj) {
		Node curr = head;

		while (curr.next != null) {
			curr = curr.next;
		}
		n++;
		curr.next = new Node(obj, null);
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

		Node curr = head;

		while (curr.next != null) {
			sb.append(curr.data);
			curr = curr.next;
			sb.append(", ");
		}
		
		sb.append("]");
		return sb.toString();
	}
}