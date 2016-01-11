public class Vector {

	/** Implementing a vector (a dynamic array) **/

	private int size;
	private String[] array;

	public Vector() {
		this.size = 0;
		array = new String[4];
	}

	public int size() {
		return size;
	}

	public int curentCapacity() {
		return array.length;
	}

	public String get(int index) {
		if (index < 0 || index >= size)
			return "Invalid index!";
		return array[index];
	}

	public String set(int index, String val) {
		if (index < 0 || index >= size)
			return "Invalid index!";
		array[index] = val;
		return "Updated";
	}

	public boolean contains(String val) {
		for (int i = 0; i < size; i += 1) {
			if (array[i].equals(val))
				return true;
		}
		return false;
	}

	public void add(String val) {
		if (size >= array.length)
			expandArray();
		array[size] = val;
		size += 1;
	}

	public String addAt(int index, String val) {
		if (index < 0 || index > size)
			return "Invalid index!";
		if (size >= array.length)
			expandArray();
		makeHoleAt(index);
		array[index] = val;
		size += 1;
		return "Done adding";
	}

	public String removeAt(int index) {
		if (index < 0 || index >= size)
			return "Invalid index!";
		for (int i = index; i < size - 1; i += 1)
			array[i] = array[i + 1];
		size -= 1;
		return "Done removing";
	}

	public String remove(String val) {
		for (int i = 0; i < size; i += 1) {
			if (array[i].equals(val)) {
				removeAt(i);
				return "Removed";
			}
		}
		return "Value did not exist";
	}

	private void makeHoleAt(int index) {
		for (int i = size + 1; i > index; i -= 1) {
			array[i] = array[i - 1];
		}
	}

	private void expandArray() {
		String[] newArray = new String[2 * array.length];
		for (int i = 0; i < array.length; i += 1)
			newArray[i] = array[i];
		array = newArray;
	}

	public String toString() {
		String view = "[ ";
		for (int i = 0; i < size; i += 1) {
			view += (i == size - 1) ? array[i] : array[i] + ", ";
		}
		view += " ]";
		return view;
	}

	public static void main(String[] args) {
		// Try out the vector
		Vector myVector = new Vector();
		System.out.println("Print an empty vector: ");
		System.out.println(myVector);
		System.out.println("Try removing from an empty vector:");
		System.out.println(myVector.removeAt(0));
		System.out.println("Add something:");
		myVector.add("" + -1);
		System.out.println(myVector);
		System.out.println("What is the current capacity?:");
		System.out.println(myVector.curentCapacity());

		System.out.println("Try adding a lot of stuff:");
		for (int i = 0; i < 15; i += 1)
			myVector.add("" + i);
		System.out.println(myVector);
		System.out.println("What is the capacity now?:");
		System.out.println(myVector.curentCapacity());
		System.out.println("Does it contain -2?");
		System.out.println(myVector.contains("-2"));
		System.out.println("What is the 2nd to last element? Set it to 20:");
		System.out.println(myVector.get(myVector.size() - 2));
		myVector.set(myVector.size() - 2, "20");
		System.out.println(myVector);

		System.out.println("Now add 21 at the third spot:");
		myVector.addAt(2, "21");
		System.out.println(myVector);
		System.out.println("What is the capacity now?");
		System.out.println(myVector.curentCapacity());
		System.out
				.println("Undo the last change and remove 21 from the 3rd spot:");
		myVector.removeAt(2);
		System.out.println(myVector);
		System.out.println("Remove the last element:");
		myVector.removeAt(myVector.size() - 1);
		System.out.println(myVector);
		System.out.println("Now add it back:");
		myVector.add("14");
		System.out.println(myVector);
	}

}
