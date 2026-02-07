import java.util.*;

@SuppressWarnings("unchecked")
public class ArrayStack<Item> implements Iterable<Item> {
	private Item[] stack = (Item[]) new Object[2];
	private int n;

	public int size() {
		return n;
	}

	private void resize(int n) {
		Item[] copy = (Item[]) new Object[n];
		for (int i = 0; i < Math.min(n, this.n); i++) {
			copy[i] = stack[i];
		}
		stack = copy;
	}

	public void push(Item object) {
		if (n == stack.length) resize(n * 2);
		stack[n++] = object;
	}

	public Item pop() {
		if (n == 0) {
			return null;
		}
		Item i = stack[--n];

		stack[n] = null;
		if (n > 0 && n <= stack.length / 4) {
			resize(stack.length / 2);
		}

		return i;
	}

	public Item peek() {
		if (n == 0) {
			return null;
		}
		return stack[n - 1];
	}

	public Iterator<Item> iterator() {
		return new StackIterator();
	}

	class StackIterator implements Iterator<Item> {
		private int i = n - 1;

		public boolean hasNext() {
			return i >= 0;
		}

		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			return stack[i--];
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = n - 1; i >= 0; i--) {
			sb.append(stack[i]);
			if (i != 0) sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}
}