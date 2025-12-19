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

		ArrayDeque<Integer> aDeque = new ArrayDeque<>();

		aDeque.addLast(1);
		aDeque.addFirst(2);
		aDeque.addLast(3);

		System.out.println(aDeque);

		System.out.println(aDeque.removeFirst());
		System.out.println(aDeque.removeLast());
		System.out.println(aDeque.removeFirst());

		// -----------------------------------------------------------------------------

		LLDeque<Integer> llDeque = new LLDeque<>();

		llDeque.addLast(1);
		llDeque.addFirst(2);
		llDeque.addLast(3);

		System.out.println(llDeque);

		System.out.println(llDeque.removeFirst());
		System.out.println(llDeque.removeLast());
		System.out.println(llDeque.removeFirst());

		// -----------------------------------------------------------------------------

		aArrayList<Integer> aaList = new aArrayList<>();

		aaList.add(1);
		aaList.add(1, 2);
		aaList.add(3);

		System.out.println(aaList);

		System.out.println(aaList.get(0));
		System.out.println(aaList.set(1, 4));
		System.out.println(aaList.remove(1));

		// -----------------------------------------------------------------------------

		llArrayList<Integer> llAList = new llArrayList<>();

		llAList.add(1);
		llAList.add(1, 2);
		llAList.add(3);

		System.out.println(llAList);

		System.out.println(llAList.get(0));
		System.out.println(llAList.set(1, 4));
		System.out.println(llAList.remove(1));

	}
}