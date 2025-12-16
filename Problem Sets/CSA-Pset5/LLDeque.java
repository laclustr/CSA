import java.util.*;

@SuppressWarnings("unchecked")
public class ArrayDeque<Item> {
	Node<Item> head, tail;
	int n;

	public int size() {
		return n;
	}

	public void addFirst(Item i) {
		Node<Item> newNode = new Node(i, head);
		head = newNode;
		n++;
	}

	public void addLast(Item i) {
		Node<Item> newNode = new Node(i, null, tail);
		tail.next = newNode;
		n++
	}

	public Item removeFirst() {
		if (n == 0) return null;
		Node<Item> node = head;
		head.next.prev = null;
		head = head.next;
		n--;

		return node.data;
	}

	public Item removeLast() {
		Node<Item> node = tail;
		tail = tail.prev;
		tail.prev.next = null;

		return node.data;
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