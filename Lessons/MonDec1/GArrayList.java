public class GArrayList<Item> {
	private Item[] arr = (Item[]) new Object[8];
	private int n;

	private void resize(int capacity) {
		Item[] temp = (Item[]) new Object[capacity];
		
		for (int i = 0; i < n; i++) {
			temp[i] = arr[i];
		}

		arr = temp;
	}

	public int size() {
		return n;
	}

	public void add(Item item) {
		if (n == arr.length) {
			resize(2*arr.length);
		}
		arr[n] = item;
		n++;
	}

	public Item get(int idx) {
		if (idx >= n) {
			throw new ArrayIndexOutOfBoundsException(idx + " is not a valid index for DArrayList of size " + size());
		}
		return arr[idx];
	}

	public Item remove(int idx) {
		if (idx >= n) {
			throw new ArrayIndexOutOfBoundsException(idx + " is not a valid index for DArrayList of size " + size());
		}

		Item item = arr[idx];

		for (int i = idx; i < n - 1; i++) {
			arr[i] = arr[i + 1];
		}

		n--;

		if (n <= arr.length / 4) {
			resize(arr.length / 2);
		}

		return item;
	}

	public void set(int idx, Item element) {
		if (idx >= n) {
			throw new ArrayIndexOutOfBoundsException(idx + " is not a valid index for DArrayList of size " + size());
		}

		arr[idx] = element;
	}

	public String toString() {
		StringBuilder result = new StringBuilder("[");
		for (int i = 0; i < n; i++) {
			if (i != n - 1) result.append(arr[i] + ", ");
			else            result.append(arr[i] + "]");
		}

		return result.toString();
	}

}