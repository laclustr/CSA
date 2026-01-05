public class LinkedList<Item> {
	private Node<Item> head;
	private int n;

	public int size() {
		return n;
	}

	public void add(Item item) {
		Node<Item> curr = head;

		if (head == null) {
			head = new Node<>(item);
			n++;
			return;
		}

		while (curr.next != null) {
			curr = curr.next;
		}

		curr.next = new Node<>(item);
		n++;
	}

	public Item getMiddle() {
		if (head == null) return null;

		Node<Item> slow = head;
		Node<Item> fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.data;
	}

	public boolean hasCycle() {
		Node<Item> slow = head;
		Node<Item> fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) return true;
		}
		return false;
	}

	public void reverse() {
		Node<Item> curr = head;
		Node<Item> prev = null;

		while (curr != null) {
			Node<Item> next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		head = prev;
	}

	public void removeAll(Item key) {
		while (head != null && head.data.equals(key)) {
			head = head.next;
			n--;
		}

		Node<Item> curr = head;

		while (curr != null && curr.next != null) {
			if (curr.next.data.equals(key)) {
				curr.next = curr.next.next;
				n--;
			} else { 
				curr = curr.next;
			}
		}
	}

	public void swapInPairs() {
		if (head == null || head.next == null) return;

		Node<Item> prev = null;
		Node<Item> curr = head;
		head = head.next;

		while (curr != null && curr.next != null) {
			Node<Item> next = curr.next;
			Node<Item> nextnext = curr.next.next;

			next.next = curr;
			curr.next = nextnext;

			if (prev != null) prev.next = next;

			prev = curr;
			curr = nextnext;
		}
	}

	public static <Item extends Comparable<Item>> 
	LinkedList<Item> merge(LinkedList<Item> li1, LinkedList<Item> li2) {
		LinkedList<Item> result = new LinkedList<>();

		Node<Item> curr1 = li1.head;
		Node<Item> curr2 = li2.head;

		while (curr1 != null && curr2 != null) {
				if (curr1.data.compareTo(curr2.data) <= 0) {
					result.add(curr1.data);
					curr1 = curr1.next;
				} else {
					result.add(curr2.data);
					curr2 = curr2.next;
				}
			}

			while (curr1 != null) {
				result.add(curr1.data);
				curr1 = curr1.next;
			}

			while (curr2 != null) {
				result.add(curr2.data);
				curr2 = curr2.next;
			}

			return result;
	}

}