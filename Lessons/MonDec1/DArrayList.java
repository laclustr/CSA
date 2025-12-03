public class DArrayList {
	private int[] nums = new int[8];
	private int n;

	private void resize(int capacity) {
		int[] temp = new int[capacity];
		
		for (int i = 0; i < n; i++) {
			temp[i] = nums[i];
		}

		nums = temp;
	}

	public int size() {
		return n;
	}

	public void add(int num) {
		if (n == nums.length) {
			resize(2*nums.length);
		}
		nums[n] = num;
		n++;
	}

	public int get(int idx) {
		if (idx >= n) {
			throw new ArrayIndexOutOfBoundsException(idx + " is not a valid index for DArrayList of size " + size());
		}
		return nums[idx];
	}

	public int remove(int idx) {
		if (idx >= n) {
			throw new ArrayIndexOutOfBoundsException(idx + " is not a valid index for DArrayList of size " + size());
		}

		int item = nums[idx];

		for (int i = idx; i < n - 1; i++) {
			nums[i] = nums[i + 1];
		}

		n--;

		if (n <= nums.length / 4) {
			resize(nums.length / 2);
		}

		return item;
	}

	public void set(int idx, int element) {
		if (idx >= n) {
			throw new ArrayIndexOutOfBoundsException(idx + " is not a valid index for DArrayList of size " + size());
		}

		nums[idx] = element;
	}

	public String toString() {
		StringBuilder result = new StringBuilder("[");
		for (int i = 0; i < n; i++) {
			if (i != n - 1) result.append(nums[i] + ", ");
			else            result.append(nums[i] + "]");
		}

		return result.toString();
	}

}