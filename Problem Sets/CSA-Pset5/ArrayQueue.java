import java.util.*;

@SuppressWarnings("unchecked")
public class ArrayQueue<Item> {
	Item[] queue = (Item[]) new Object[2];
	int head = 0;
	int n = 0;

	public int size() {
		return n;
	}

	private void resize(int size) {
		Item[] copy = (Item[]) new Object[size];
		for (int i = 0; i < n; i++) {
			copy[i] = queue[(head + i) % queue.length];
		}
		queue = copy;
		head = 0;
	}

	public void enqueue(Item obj) {
		if (n == queue.length) resize(queue.length * 2);

		queue[(head + n) % queue.length] = obj;
		n++;
	} 

	public Item dequeue() {
		if (n == 0) return null;

		Item item = queue[head];
		queue[head] = null;
		head = (head + 1) % queue.length;
		n--;

		if (n > 0 && n == queue.length / 4) resize(queue.length / 2);

		return item;
	}

	public Item peek() {
		if (n == 0) return null;
		return queue[head];
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");

		for (int i = 0; i < n; i++) {
			sb.append(queue[(head + i) % queue.length]);
			if (i != n - 1) sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}
}