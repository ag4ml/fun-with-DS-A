public class Stack {

	/** Implementing an array-based stack **/

	private String[] stack;
	private int top;

	public Stack(int size) {
		this.top = 0;
		this.stack = new String[size];
	}

	public String pop() {
		if (top == 0)
			return "Empty Stack!";
		else {
			top -= 1;
			return stack[top];
		}
	}

	public String push(String s) {
		if (top == stack.length)
			return "Full Stack!";
		else {
			stack[top] = s;
			top += 1;
			return "Pushed " + s;
		}
	}

	public String peek() {
		return (top == 0) ? "Nothing to see here!" : stack[top - 1];
	}

	public String toString() {
		String view = "";
		for (int i = top - 1; i >= 0; i -= 1)
			view += stack[i] + " -> ";
		view += "|||";
		return view;
	}

	public static void main(String[] args) {
		// Try out the stack
		Stack myStack = new Stack(10);
		System.out.println("Printing an empty stack:");
		System.out.println(myStack);
		System.out.println("Peeking and popping an empty stack:");
		System.out.println(myStack.peek());
		System.out.println(myStack.pop());
		for (int i = 0; i < 10; i += 2)
			myStack.push("" + i);
		System.out.println("Stack after adding some stuff:");
		System.out.println(myStack);

		System.out.println("Removing the top element:");
		myStack.pop();
		System.out.println(myStack);
		System.out.println("What's the new top element?:");
		System.out.println(myStack.peek());
		System.out.println("Trying to overflow stack:");
		for (int i = 10; i < 18; i += 1)
			System.out.println(myStack.push("" + i));
		System.out.println(myStack);
	}

}
