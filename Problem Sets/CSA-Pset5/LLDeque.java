import java.util.*;

@SuppressWarnings("unchecked")
public class LLDeque<Item> {
	Node<Item> head, tail;
	int n;

	public int size() {
		return n;
	}

	public void addFirst(Item i) {
		Node<Item> newNode = new Node<>(i, head);

		if (n == 0) tail = newNode;
		else head.prev = newNode;

		head = newNode;
		n++;
	}

	public void addLast(Item i) {
		Node<Item> newNode = new Node<>(i, null, tail);

		if (n == 0) head = newNode;
		else tail.next = newNode;

		tail = newNode;
		n++;
	}

	public Item removeFirst() {
		if (n == 0) return null;
		
		Item data = head.data;
		head = head.next;

		n--;

		if (n == 0) tail = null;
		else head.prev = null;

		return data;
	}

	public Item removeLast() {
		if (n == 0) return null;

		Item data = tail.data;
		tail = tail.prev;
		
		n--;

		if (n == 0) head = null;
		else tail.next = null;

		return data;
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