import java.util.TreeMap;

public class Trie {

	/** A trie structure that's useful for retrieval like hashtables **/

	private class TrieNode {
		/** A class to represent a node in a trie **/

		boolean isWord;
		String val;
		TreeMap<String, TrieNode> children;

		public TrieNode(String val, boolean isWord) {
			this.val = val;
			this.isWord = isWord;
			children = new TreeMap<>();
		}
	}

	private TrieNode root;

	public Trie() {
		this.root = new TrieNode("Root", false);
	}

	public void insertKey(String key) {
		if (contains(key))
			return;
		int i = 0;
		TrieNode node = root;
		while (i < key.length()) {
			if (node.children.get("" + key.charAt(i)) != null) {
				node = node.children.get("" + key.charAt(i));
				if (i == key.length() - 1)
					node.isWord = true;
				i += 1;
			} else
				break;
		}
		while (i < key.length()) {
			TrieNode newNode;
			if (i == key.length() - 1) {
				newNode = new TrieNode(key.substring(0, i) + key.charAt(i),
						true);
			} else {
				newNode = new TrieNode(key.substring(0, i) + key.charAt(i),
						false);
			}
			node.children.put("" + key.charAt(i), newNode);
			node = newNode;
			i += 1;
		}
	}

	public boolean contains(String key) {
		TrieNode node = root;
		int i = 0;
		while (node != null && i < key.length()) {
			node = node.children.get(key.charAt(i) + "");
			i += 1;
		}
		return (node == null || !node.isWord) ? false : true;

	}

	public String toString() {
		String val = preOrder(root);
		return val.substring(0, val.length() - 2);
	}

	private String preOrder(TrieNode node) {
		String myVal = (node == root || !node.isWord) ? "" : node.val + ", ";
		String childrenVal = "";
		for (String child : node.children.keySet()) {
			childrenVal += preOrder(node.children.get(child));
		}
		return myVal + childrenVal;
	}

	public static void main(String[] args) {
		// Try out the trie
		Trie myTrie = new Trie();
		System.out.println("Let's try adding some sets of strings");
		String[] keys = { "rat", "int", "ratatata", "calculate", "dog",
				"feature", "diamond", "interest", "feat" };
		for (int i = 0; i < keys.length; i += 1)
			myTrie.insertKey(keys[i]);
		System.out.println("Does it contain cat: ");
		System.out.println(myTrie.contains("cat"));
		System.out.println("Does it contain dog: ");
		System.out.println(myTrie.contains("dog"));
		System.out.println("Does it contain doggie: ");
		System.out.println(myTrie.contains("doggie"));
		System.out.println("Does it contain rat: ");
		System.out.println(myTrie.contains("rat"));
		System.out.println("Does it contain ratatata: ");
		System.out.println(myTrie.contains("ratatata"));
		System.out.println("Does it contain feature: ");
		System.out.println(myTrie.contains("feature"));
		System.out.println("Does it contain feat: ");
		System.out.println(myTrie.contains("feat"));
		System.out.println("Show me the keys in this trie in sorted order: ");
		System.out.println(myTrie);
	}

}
