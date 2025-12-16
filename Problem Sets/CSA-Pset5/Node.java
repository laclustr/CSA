public class Node<Item> {
	public Node prev;
	public Node next;
	public Item data;

	public Node(Item data) {
		this.data = data;
	}

	public Node(Item data, Node next) {
		this.data = data;
		this.next = next;
	}

	public Node(Item data, Node next, Node prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
}