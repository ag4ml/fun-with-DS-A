public class Queue {

	/** Implementing a queue using doubly linked nodes and sentinels **/

	private class DLinkedNode {

		/** Class to implement a node in a doubly-linked list */

		String data;
		DLinkedNode prev;
		DLinkedNode next;
		boolean sentinel;

		public DLinkedNode(String val, boolean isSentinel) {
			this.data = val;
			this.sentinel = isSentinel;
			this.prev = null;
			this.next = null;
		}
	}

	private DLinkedNode head;
	private DLinkedNode tail;

	public Queue() {
		this.head = new DLinkedNode("0", true);
		this.tail = new DLinkedNode("1", true);
		head.next = tail;
		tail.prev = head;
	}

	public void enqueue(String val) {
		DLinkedNode newNode = new DLinkedNode(val, false);
		newNode.prev = head;
		newNode.next = head.next;
		head.next.prev = newNode;
		head.next = newNode;
	}

	public String dequeue() {
		if (tail.prev.sentinel)
			return "Nothing to dequeue";
		else {
			String removed = tail.prev.data;
			tail.prev = tail.prev.prev;
			tail.prev.next = tail;
			return removed;
		}
	}

	public String toString() {
		DLinkedNode current = head.next;
		String view = "Start";
		while (current != tail) {
			view += " -- " + current.data;
			current = current.next;
		}
		view += " -- End";
		return view;
	}

	public static void main(String[] args) {
		// Try out the queue
		Queue myQueue = new Queue();
		System.out.println("Printing out empty queue:");
		System.out.println(myQueue);
		System.out.println("Try to dequeue empty queue:");
		System.out.println(myQueue.dequeue());
		System.out.println("Enqueue -1");
		myQueue.enqueue("-1");
		System.out.println(myQueue);
		for (int i = 0; i < 10; i += 2)
			myQueue.enqueue("" + i);
		System.out.println("Add more stuff to the queue:");
		System.out.println(myQueue);
		System.out.println("What's the first thing to dequeue? Dequeue it:");
		System.out.println(myQueue.dequeue());
		System.out.println(myQueue);

	}
}
