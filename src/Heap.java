import java.util.Arrays;

public class Heap {
	/** Implementing a min-heap with basic operations **/

	private Vector heap;
	private int top;

	public Heap() {
		this.heap = new Vector();
		this.heap.add("0th index reserved");
		this.top = 1;
	}

	public String findMin() {
		return (top != 1) ? heap.get(1) : "Empty heap!";
	}

	public void insert(String val) {
		heap.add(val);
		top += 1;
		percolateUp(top - 1);
	}

	public String extractMin() {
		if (top == 1)
			return "Empty heap!";
		String retVal = findMin();
		heap.set(1, heap.get(top - 1));
		heap.removeAt(top - 1);
		top -= 1;
		percolateDown(1);
		return retVal;
	}

	private void percolateDown(int i) {
		int left = 2 * i;
		int right = 2 * i + 1;
		while (left < top || right < top) {
			int minChild;
			if (heap.get(left) != null && heap.get(right) != null) {
				minChild = (heap.get(left).compareTo(heap.get(right)) > 0) ? right
						: left;
			} else if (heap.get(left) == null)
				minChild = right;
			else
				minChild = left;
			if (heap.get(minChild).compareTo(heap.get(i)) >= 0)
				break;
			String temp = heap.get(i);
			heap.set(i, heap.get(minChild));
			heap.set(minChild, temp);
			i = minChild;
			left = 2 * i;
			right = 2 * i + 1;
		}

	}

	private void percolateUp(int i) {
		int parent = i / 2;
		while (parent != 0 && heap.get(parent).compareTo(heap.get(i)) > 0) {
			String temp = heap.get(parent);
			heap.set(parent, heap.get(i));
			heap.set(i, temp);
			i = parent;
			parent = i / 2;
		}
	}

	public static void main(String[] args) {
		// Try out the heap
		Heap myHeap = new Heap();
		int[] test = { 4, 5, 7, 2, 9, 1, 0, 3, 6, 8 };
		System.out.println("Insert following elements into the heap: ");
		System.out.println(Arrays.toString(test));
		for (int i : test)
			myHeap.insert("" + i);
		System.out
				.println("Use extract min several times to obtain sorted version: ");
		for (int i = 0; i < test.length; i += 1)
			test[i] = Integer.parseInt(myHeap.extractMin());
		System.out.println(Arrays.toString(test));

	}

}
