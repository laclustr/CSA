public class Node<Item> {
	public Node<Item> prev;
	public Node<Item> next;
	public Item data;

	public Node(Item data) {
		this.data = data;
	}

	public Node(Item data, Node<Item> next) {
		this.data = data;
		this.next = next;
	}

	public Node(Item data, Node<Item> next, Node<Item> prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
}