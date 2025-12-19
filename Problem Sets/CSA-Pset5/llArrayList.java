import java.util.*;

@SuppressWarnings("unchecked")
public class llArrayList<Item> {
	private Node<Item> head;
	private int n;

	public int size() {
		return n;
	}

	public void add(Item i) {
		if (n < 1) {
			head = new Node<Item>(i);
			n++;
			return;
		}

		Node<Item> curr = head;

		while (curr.next != null) {
			curr = curr.next;
		}

		curr.next = new Node<Item>(i);
		n++;
	}

	public void add(int idx, Item item) {
		if (idx < 0 || idx > n) throw new ArrayIndexOutOfBoundsException();

		if (n == 0) {
			Node<Item> node = new Node<Item>(item);
			node.next = head;
			head = node;
			n++;
			return;
		}

		Node<Item> curr = head;
		for (int i = 0; i < idx - 1; i++) {
			curr = curr.next;
		}

		Node<Item> node = new Node<Item>(item);
		node.next = curr.next;
		curr.next = node;
		n++;
	}

	public Item get(int idx) {
		if (idx < 0 || idx >= n) throw new ArrayIndexOutOfBoundsException();
		
		Node<Item> curr = head;
		for (int i = 0; i < idx; i++) {
			curr = curr.next;
		}

		return curr.data;
	}

	public Item set(int idx, Item item) {
		if (idx < 0 || idx >= n) throw new ArrayIndexOutOfBoundsException();

		Node<Item> curr = head;
		for (int i = 0; i < idx; i++) {
			curr = curr.next;
		}

		Item data = curr.data;
		curr.data = item;

		return data;
	}

	public Item remove(int idx) {
		if (idx < 0 || idx >= n) throw new ArrayIndexOutOfBoundsException();

		Item data;

		if (idx == 0) {
			data = head.data;
			head = head.next;
		} else {
			Node<Item> curr = head;
			for (int i = 0; i < idx - 1; i++) {
				curr = curr.next;
			}
			data = curr.next.data;
			curr.next = curr.next.next;
		}

		n--;

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