import java.util.*;

@SuppressWarnings("unchecked")
public class LLStack<Item> {
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

	public void push(Item object) {
		head = new Node(object, head);
		n++;
	}

	public Item pop() {
		if (n == 0) return null;

		Item item = head.data;
		head = head.next;
		n--;
		return item;
	}

	public Item peek() {
		if (n == 0) {
			return null;
		}
		return head.data;
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