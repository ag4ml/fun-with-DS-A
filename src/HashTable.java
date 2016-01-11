public class HashTable {
	/**
	 * A very simple hash table with separate chaining and an impressive hash
	 * function.
	 **/

	private Vector[] hasht;
	private double loadFactor = 0.8;

	public HashTable(int keySize) {
		this.hasht = new Vector[(int) (keySize / loadFactor)];
		for (int i = 0; i < this.hasht.length; i += 1)
			hasht[i] = new Vector();
	}

	public void insert(String val) {
		if (!contains(val))
			hasht[hashfunc(val)].add(val);
	}

	public boolean contains(String val) {
		return hasht[hashfunc(val)].contains(val);
	}

	public String remove(String val) {
		return hasht[hashfunc(val)].remove(val);
	}

	// Super duper awesome hash function invented by someone else
	private int hashfunc(String val) {
		long hash = 5381;
		for (int i = 0; i < val.length(); i += 1) {
			hash = hash * 33 + (int) val.charAt(i);
		}
		return (int) (hash % hasht.length);
	}

	public String toString() {
		String view = "";
		int items = 0;
		int bucketsUsed = 0;
		for (int i = 0; i < hasht.length; i += 1) {
			if (hasht[i].size() == 0)
				continue;
			view += i + ": ";
			bucketsUsed += 1;
			for (int j = 0; j < hasht[i].size(); j += 1) {
				view += (j != hasht[i].size() - 1) ? hasht[i].get(j) + ", "
						: hasht[i].get(j);
				items += 1;
			}
			view += "\n";
		}
		view += "No of keys and avg number of keys per bucket used: " + items
				+ ", " + (double) items / bucketsUsed;
		return view;
	}

	public static void main(String[] args) {
		// Try out the hashtable
		HashTable myHt = new HashTable(6 * 6 * 6);
		addStringsRecursively(myHt, "");
		System.out.println(myHt);
		System.out.println("Does it contain abc?");
		System.out.println(myHt.contains("abc"));
		System.out.println("Does it contain zyx?");
		System.out.println(myHt.contains("zyx"));
		System.out.println("Remove abc and then check if it exists");
		myHt.remove("abc");
		System.out.println(myHt.contains("abc"));
	}

	private static void addStringsRecursively(HashTable myHt, String temp) {
		if (temp.length() == 3)
			myHt.insert(temp);
		else {
			for (int i = 97; i < 103; i += 1) {
				addStringsRecursively(myHt, (char) i + temp);
			}
		}
	}

}
