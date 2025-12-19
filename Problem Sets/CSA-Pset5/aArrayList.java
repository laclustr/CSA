import java.util.*;

@SuppressWarnings("unchecked")
public class aArrayList<Item> {
	private Item[] list = (Item[]) new Object[2];
	private int n;

	public int size() {
		return n;
	}

	private void resize(int size) {
		Item[] copy = (Item[]) new Object[size];

		for (int i = 0; i < n; i++) {
			copy[i] = list[i];
		}

		list = copy;
	}

	public void add(Item i) {
		if (n >= list.length) resize(list.length * 2);

		list[n++] = i;
	}

	public void add(int idx, Item item) {
		if (idx < 0 || idx > n) throw new ArrayIndexOutOfBoundsException();
		if (n >= list.length) resize(list.length * 2);

		for (int i = n; i > idx; i--) {
			list[i] = list[i - 1];
		}

		list[idx] = item;
		n++;
	}

	public Item get(int idx) {
		if (idx < 0 || idx >= n) throw new ArrayIndexOutOfBoundsException();
		else {
			return list[idx];
		}
	}

	public Item set(int idx, Item i) {
		if (idx < 0 || idx >= n) throw new ArrayIndexOutOfBoundsException();
		Item old = list[idx];
		list[idx] = i;

		return old;
	}

	public Item remove(int idx) {
		if (idx < 0 || idx >= n) throw new ArrayIndexOutOfBoundsException();

		Item item = list[idx];

		for (int i = idx; i < n - 1; i++) {
			list[i] = list[i + 1];
		}

		list[--n] = null;
		return item;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");

		for (int i = 0; i < n; i++) {
			sb.append(list[i]);
			if (i != n - 1) sb.append(", ");
		}

		sb.append("]");
		return sb.toString();
	}
}