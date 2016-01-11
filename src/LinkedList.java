public class LinkedList {

	/** Implementing a singly linked list. **/

	private class ListNode {

		/** A class to represent a node in a list. **/

		int data;
		ListNode next;

		public ListNode(int val) {
			this.data = val;
			this.next = null;
		}

	}

	private ListNode head;

	public LinkedList() {
		this.head = null;
	}

	public void prepend(int x) {
		ListNode inserted = new ListNode(x);
		if (head == null)
			head = inserted;
		else {
			inserted.next = head;
			head = inserted;
		}
	}

	public void append(int x) {
		ListNode inserted = new ListNode(x);
		if (head == null)
			head = inserted;
		else {
			ListNode currrent = head;
			while (currrent.next != null)
				currrent = currrent.next;
			currrent.next = inserted;
		}
	}

	public void insertAfter(int val, int newVal) {
		if (!this.contains(val))
			return;
		ListNode current = head;
		while (current.data != val)
			current = current.next;
		ListNode newNode = new ListNode(newVal);
		if (current.next == null)
			current.next = newNode;
		else {
			newNode.next = current.next;
			current.next = newNode;
		}
	}

	public boolean contains(int val) {
		if (head == null)
			return false;
		ListNode current = head;
		while (current != null) {
			if (current.data == val)
				return true;
			current = current.next;
		}
		return false;
	}

	public void removeFirst() {
		if (head == null)
			return;
		head = head.next;
	}

	public void remove(int val) {
		if (!this.contains(val))
			return;
		ListNode current = head;
		ListNode prev = null;
		while (current.data != val) {
			prev = current;
			current = current.next;
		}
		prev.next = current.next;
	}

	public void removeAfter(int val) {
		if (!this.contains(val))
			return;
		ListNode current = head;
		while (current.data != val)
			current = current.next;
		if (current.next == null)
			return;
		current.next = current.next.next;
	}

	public String toString() {
		String list = "";
		ListNode current = head;
		while (current != null) {
			list += current.data + " -> ";
			current = current.next;
		}
		list += "|||";
		return list;
	}

	public static void main(String[] args) {
		// Try out the list
		LinkedList myList = new LinkedList();
		System.out.println("Print out empty list:");
		System.out.println(myList);
		for (int i = 0; i <= 10; i += 2)
			myList.append(i);
		System.out.println("Print out list with stuff in it:");
		System.out.println(myList);
		System.out.println("Does it contain 4?");
		System.out.println(myList.contains(4));

		myList.insertAfter(0, 1);
		System.out.println("List after inserting 1 following 0:");
		System.out.println(myList);
		myList.prepend(-1);
		System.out.println("Adding -1 to the front:");
		System.out.println(myList);
		System.out.println("Does it contain -1?");
		System.out.println(myList.contains(-1));

		myList.removeFirst();
		System.out.println("Removing an element from front:");
		System.out.println(myList);
		System.out.println("Does list contain -1?");
		System.out.println(myList.contains(-1));
		myList.removeFirst();
		System.out.println("Removing another element from front:");
		System.out.println(myList);

		myList.remove(4);
		System.out.println("Removing 4 from the list:");
		System.out.println(myList);
		myList.removeAfter(2);
		System.out.println("Removing node following 2:");
		System.out.println(myList);
		myList.insertAfter(1, 0);
		System.out.println("Inserting 0 after 1:");
		System.out.println(myList);
	}

}
