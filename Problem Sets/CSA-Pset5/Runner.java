import java.util.*;

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

		AArrayList<Integer> aaList = new AArrayList<>();

		aaList.add(1);
		aaList.add(1, 2);
		aaList.add(3);

		System.out.println(aaList);

		System.out.println(aaList.get(0));
		System.out.println(aaList.set(1, 4));
		System.out.println(aaList.remove(1));

		// -----------------------------------------------------------------------------

		LLArrayList<Integer> llAList = new LLArrayList<>();

		llAList.add(1);
		llAList.add(1, 2);
		llAList.add(3);

		System.out.println(llAList);

		System.out.println(llAList.get(0));
		System.out.println(llAList.set(1, 4));
		System.out.println(llAList.remove(1));

		// -----------------------------------------------------------------------------

		ARandomizedQueue<Integer> aRandQueue = new ARandomizedQueue<>();

		aRandQueue.enqueue(1);
		aRandQueue.enqueue(2);
		aRandQueue.enqueue(3);

		System.out.println(aRandQueue);

		System.out.println(aRandQueue.dequeue());
		System.out.println(aRandQueue.dequeue());
		System.out.println(aRandQueue.sample());
		System.out.println(aRandQueue.dequeue());

		// -----------------------------------------------------------------------------

		LLRandomizedQueue<Integer> llRandQueue = new LLRandomizedQueue<>();

		llRandQueue.enqueue(1);
		llRandQueue.enqueue(2);
		llRandQueue.enqueue(3);

		System.out.println(llRandQueue);

		System.out.println(llRandQueue.dequeue());
		System.out.println(llRandQueue.dequeue());
		System.out.println(llRandQueue.sample());
		System.out.println(llRandQueue.dequeue());

		// -----------------------------------------------------------------------------

		System.out.println(removeDuplicates(new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1, 5)))); // [1, 2, 3, 5]
		System.out.println(removeDuplicates(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 2, 3)))); // [1, 2, 3]
	
		// -----------------------------------------------------------------------------

		System.out.println(isBalanced("()"));     // true
		System.out.println(isBalanced("({[]})")); // true
		System.out.println(isBalanced("{)(}"));	  // false
		System.out.println(isBalanced("([)]"));	  // false
		System.out.println(isBalanced("((("));	  // false
	}

	public static <Item> ArrayList<Item> removeDuplicates(ArrayList<Item> list) {
		HashSet<Item> seen = new HashSet<>();

		for (int i = 0; i < list.size(); i++) {
			if (seen.contains(list.get(i))) list.remove(i--);
			else seen.add(list.get(i));
		}

		return list;
	}

	public static boolean isBalanced(String str) {
		LLStack<Character> stack = new LLStack<>();

		Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

		for (char c : str.toCharArray()) {
			if (map.containsValue(c)) stack.push(c);
			else if (map.containsKey(c)) {
				if (stack.size() <= 0) return false;

				if (stack.pop() != map.get(c)) return false;
			}
		}

		return stack.size() == 0;
	} 
}