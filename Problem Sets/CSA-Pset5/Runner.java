@SuppressWarnings("unchecked")
public class Runner {
	public static void main(String[] args) {
		ArrayStack<Integer> aStack = new ArrayStack<>();

		aStack.push(1);
		aStack.push(2);
		aStack.push(3);

		System.out.println(aStack);

		System.out.println(aStack.pop());
		System.out.println(aStack.pop());
		System.out.println(aStack.peek());
		System.out.println(aStack.pop());

		// -----------------------------------------------------------------------------

		LLStack<Integer> llStack = new LLStack<>();

		llStack.push(1);
		llStack.push(2);
		llStack.push(3);

		System.out.println(llStack);

		System.out.println(llStack.pop());
		System.out.println(llStack.pop());
		System.out.println(llStack.peek());
		System.out.println(llStack.pop());

		// -----------------------------------------------------------------------------

		ArrayQueue<Integer> aQueue = new ArrayQueue<>();

		aQueue.enqueue(1);
		aQueue.enqueue(2);
		aQueue.enqueue(3);

		System.out.println(aQueue);

		System.out.println(aQueue.dequeue());
		System.out.println(aQueue.dequeue());
		System.out.println(aQueue.peek());
		System.out.println(aQueue.dequeue());

		// -----------------------------------------------------------------------------

		LLQueue<Integer> llQueue = new LLQueue<>();

		llQueue.enqueue(1);
		llQueue.enqueue(2);
		llQueue.enqueue(3);

		System.out.println(llQueue);

		System.out.println(llQueue.dequeue());
		System.out.println(llQueue.dequeue());
		System.out.println(llQueue.peek());
		System.out.println(llQueue.dequeue());

		// -----------------------------------------------------------------------------

		ArrayDeque<Integer> adQueue = new ArrayDeque<>();

		adQueue.addLast(1);
		adQueue.addFirst(2);
		adQueue.addLast(3);

		System.out.println(adQueue);

		System.out.println(adQueue.removeFirst());
		System.out.println(adQueue.removeLast());
		System.out.println(adQueue.removeFirst());

		// -----------------------------------------------------------------------------

		LLDeque<Integer> llQueue = new LLDeque<>();

		llQueue.addLast(1);
		llQueue.addFirst(2);
		llQueue.addLast(3);

		System.out.println(llQueue);

		System.out.println(llQueue.removeFirst());
		System.out.println(llQueue.removeLast());
		System.out.println(llQueue.removeFirst());
	}
}