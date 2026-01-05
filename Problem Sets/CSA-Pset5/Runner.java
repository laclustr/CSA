import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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

		// -----------------------------------------------------------------------------

		System.out.println(evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )")); // 101
		System.out.println(evaluate("(sqrt(((7 * 3) + (6 - 2))))")); // 5
		System.out.println(evaluate("(2 + 1.5)")); // 3.5

		// -----------------------------------------------------------------------------

		System.out.println(evaluateRPN("3 4 -"));            // -1
		System.out.println(evaluateRPN("3 4 + 5 6 + *"));    // 77
		System.out.println(evaluateRPN("13 12 + sqrt"));    // 5
		System.out.println(evaluateRPN("13 12 + 7 +"));     // 32

		// -----------------------------------------------------------------------------

		LinkedList<Integer> list3 = new LinkedList<>();
		list3.add(1);
		list3.add(2);
		list3.add(3);
		list3.add(4);
		System.out.println(list3.getMiddle()); // 3

		// -----------------------------------------------------------------------------

		LinkedList<Integer> list5 = new LinkedList<>();
		list5.add(1);
		list5.add(2);
		list5.add(3);
		list5.reverse();
		System.out.println(list5.getMiddle()); // 2

		LinkedList<Integer> list6 = new LinkedList<>();
		list6.add(10);
		list6.reverse();
		System.out.println(list6.getMiddle()); // 10

		// -----------------------------------------------------------------------------

		LinkedList<Integer> list7 = new LinkedList<>();
		list7.add(1);
		list7.add(2);
		list7.add(2);
		list7.add(3);
		list7.removeAll(2);
		System.out.println(list7.size());      // 2
		System.out.println(list7.getMiddle()); // 3

		LinkedList<Integer> list8 = new LinkedList<>();
		list8.add(2);
		list8.add(2);
		list8.add(3);
		list8.removeAll(2);
		System.out.println(list8.size());      // 1
		System.out.println(list8.getMiddle()); // 3

		// -----------------------------------------------------------------------------

		LinkedList<Integer> list9 = new LinkedList<>();
		list9.add(1);
		list9.add(2);
		list9.add(3);
		list9.add(4);
		list9.swapInPairs();
		System.out.println(list9.getMiddle()); // 4

		LinkedList<Integer> list10 = new LinkedList<>();
		list10.add(1);
		list10.add(2);
		list10.add(3);
		list10.swapInPairs();
		System.out.println(list10.getMiddle()); // 1

		// -----------------------------------------------------------------------------

		LinkedList<Integer> a = new LinkedList<>();
		a.add(1);
		a.add(3);
		a.add(5);

		LinkedList<Integer> b = new LinkedList<>();
		b.add(2);
		b.add(4);
		b.add(6);

		LinkedList<Integer> merged1 = LinkedList.merge(a, b);
		System.out.println(merged1.size());      // 6
		System.out.println(merged1.getMiddle()); // 4

		LinkedList<Integer> c = new LinkedList<>();
		LinkedList<Integer> d = new LinkedList<>();
		d.add(1);
		d.add(2);

		LinkedList<Integer> merged2 = LinkedList.merge(c, d);
		System.out.println(merged2.size());      // 2
		System.out.println(merged2.getMiddle()); // 2

	}

	// Problem 11
	public static <Item> ArrayList<Item> removeDuplicates(ArrayList<Item> list) {
		HashSet<Item> seen = new HashSet<>();

		for (int i = 0; i < list.size(); i++) {
			if (seen.contains(list.get(i))) list.remove(i--);
			else seen.add(list.get(i));
		}

		return list;
	}

	// Problem 12
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

	// Problem 13
	public static double evaluate(String str) {
		str = str
		.replaceAll("sqrt", " sqrt ")
		.replaceAll("\\(", " ( ")
		.replaceAll("\\)", " ) ")
		.replaceAll("\\+", " + ")
		.replaceAll("-", " - ")
		.replaceAll("\\*", " * ")
		.replaceAll("/", " / ")
		.trim();

		String[] chars = str.trim().split("\\s+");

		LLStack<String> ops = new LLStack<>();
		LLStack<Double> vals = new LLStack<>();

		for (String c : chars) {
			if (c.equals("(")) continue;
			else if (c.equals("+") || c.equals("-") ||
					c.equals("*") || c.equals("/") ||
					c.equals("sqrt"))
			ops.push(c);
			else if (c.equals(")")) {
				String op = ops.pop();
				if (op == null) continue; 
				double res = 0;

				if (op.equals("sqrt")) {
					res = Math.sqrt(vals.pop());
				} else {
					double b = vals.pop();
					double a = vals.pop();

					if (op.equals("+")) res = a + b;
					else if (op.equals("-")) res = a - b;
					else if (op.equals("*")) res = a * b;
					else if (op.equals("/")) res = a / b;
				}
				vals.push(res);
			} else vals.push(Double.parseDouble(c));
		}

		return vals.pop();
	}
	// End Problem 13

	public static boolean isNumber(String s) {
		try {
			Double.parseDouble(s);
			return true;
		}
		catch (NumberFormatException e) {
			return false;
		}
	}

	// Problem 14
	public static double evaluateRPN(String s) {
		LLStack<Double> operands = new LLStack<>();
		String[] vals = s.split("\\s+");
		for (int i = 0; i < vals.length; i++) {
			String c = vals[i];
			if (isNumber(c)) {
				operands.push(Double.parseDouble(c));
			}
			else if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
				String op = String.valueOf(c);

				double b = operands.pop();
				double d = operands.pop();

				if (op.equals("+")) operands.push(d + b);
				if (op.equals("-")) operands.push(d - b);
				if (op.equals("*")) operands.push(d * b);
				if (op.equals("/")) operands.push(d / b);
			}

			else if (c.equals("sqrt")) {
				double v = operands.pop();
				operands.push(Math.sqrt(v));
			}
		}
		return operands.pop();
	}
}