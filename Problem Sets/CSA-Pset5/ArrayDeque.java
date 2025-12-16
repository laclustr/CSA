import java.util.*;

@SuppressWarnings("unchecked")
public class ArrayDeque<Item> {
	Item[] deque = (Item[]) new Object[2];
	int head, n;

	public int size() {
		return n;
	}

	private void resize(int size) {
		Item[] copy = (Item[]) new Object[size];

		for (int i = 0; i < n; i++) {
			copy[i] = deque[(head + i) % deque.length];
		}

		head = 0;
		deque = copy;
	}

	public void addFirst(Item i) {
		if (n >= deque.length) resize(2 * deque.length);

		head = (head - 1 + deque.length) % deque.length;
		deque[head] = i;
		n++;
	}

	public void addLast(Item i) {
		if (n >= deque.length) resize(2 * deque.length);

		deque[(head + n++) % deque.length] = i;
	}

	public Item removeFirst() {
		if (n == 0) return null;
		if (n > 0 && n == deque.length / 4) resize(deque.length / 2);

		Item i = deque[head];
		head = (head + 1) % deque.length;
		n--;
		return i;
	}

	public Item removeLast() {
		if (n == 0) return null;
		if (n > 0 && n == deque.length / 4) resize(deque.length / 2);

		Item i = deque[(head + n-- - 1) % deque.length];
		return i;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");

		for (int i = 0; i < n; i++) {
			sb.append(deque[(head + i) % deque.length]);
			if (i < n - 1) sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}


}