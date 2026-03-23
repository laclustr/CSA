public class PQRunner {
	public static void main() {
		MaxPQ<Integer> pq = new MaxPQ<>();

		pq.add(5);
		pq.add(2);
		pq.add(9);
		pq.add(1);

		System.out.println(pq.getMax()); // 9
		System.out.println(pq.delMax()); // 9
		System.out.println(pq.delMax()); // 5
	}
}