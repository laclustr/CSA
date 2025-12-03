@SuppressWarnings("unchecked")
public class DynamicArrayList<Item> {
	private Item[] arr = (Item[]) new Object[8];
	private int n;

	private void resize(int newSize) {
		Item[] temp = arr;
		Item[] newArr = (Item[]) new Object[newSize];

		for (int i = 0; i < n; i++) {
			newArr[i] = temp[i];
		}

		arr = newArr;
	}

	public int size() {
		return n;
	}

	public Item get(int idx) {
		if (idx >= n || idx < 0) {
			throw new ArrayIndexOutOfBoundsException("Not valid index!");
		}
		return arr[idx];
	}

	public void add(Item item) {
		if (n >= arr.length) {
			resize(2 * arr.length);
		}
		arr[n++] = item;
	}


}