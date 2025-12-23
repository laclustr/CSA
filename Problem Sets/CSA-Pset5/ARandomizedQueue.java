import java.util.*;

@SuppressWarnings("unchecked")
public class ARandomizedQueue<Item> {
	private Item[] queue = (Item[]) new Object[2];
	private int head = 0;
	private int n = 0;

	private Random RNG = new Random();

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

		int idx = RNG.nextInt(n);
		Item item;

		if (idx == 0) {
			item = queue[head];
			head = (head + 1) % queue.length;
		}
		else {
			int removeIdx = (head + idx) % queue.length;
			item = queue[removeIdx];
			
			for (
				int i = removeIdx; 
				i != (head + n - 1) % queue.length; 
				i = (i + 1) % queue.length
			) {
				queue[i] = queue[(i + 1) % queue.length];
			}
			head = (head + 1) % queue.length;
		}

		queue[(head + n - 1) % queue.length] = null;

		n--;

		if (n > 0 && n == queue.length / 4) resize(queue.length / 2);

		return item;
	}

	public Item sample() {
		if (n == 0) return null;
		int idx = RNG.nextInt(n);
		return queue[(head + idx) % queue.length];
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