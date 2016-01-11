public class BST {

	/** A binary search tree **/

	private class BSTNode {

		/** A class to represent a BST Node **/

		String key;
		BSTNode lchild;
		BSTNode rchild;

		private BSTNode(String keyval) {
			this.key = keyval;
			this.lchild = null;
			this.rchild = null;
		}

		public int numChild() {
			if (lchild == null && rchild == null)
				return 0;
			else
				return (lchild != null && rchild != null) ? 2 : 1;
		}
	}

	private BSTNode root;

	public BST() {
		this.root = null;
	}

	public BSTNode find(String searchFor) {
		BSTNode temp = root;
		while (temp != null) {
			if (temp.key.equals(searchFor))
				return temp;
			else if (temp.key.compareTo(searchFor) > 0)
				temp = temp.lchild;
			else
				temp = temp.rchild;
		}
		return temp;
	}

	public boolean insert(String val) {
		if (root == null) {
			root = new BSTNode(val);
			return true;
		}
		if (find(val) != null)
			return false;
		BSTNode current = root;
		while (true) {
			if (current.key.compareTo(val) > 0) {
				if (current.lchild == null) {
					current.lchild = new BSTNode(val);
					break;
				} else
					current = current.lchild;
			} else {
				if (current.rchild == null) {
					current.rchild = new BSTNode(val);
					break;
				} else
					current = current.rchild;
			}
		}
		return true;
	}

	public String remove(String val) {
		BSTNode removeThis = find(val);
		if (removeThis == null)
			return "Does not exist!";
		if (removeThis.numChild() == 0) {
			if (removeThis == root) {
				root = null;
				return "Removed";
			}
			BSTNode parent = getParentOf(val);
			if (parent.lchild != null && parent.lchild.key.equals(val))
				parent.lchild = null;
			else
				parent.rchild = null;
		} else if (removeThis.numChild() == 1) {
			if (removeThis == root) {
				root = (root.lchild != null) ? root.lchild : root.rchild;
				return "Removed";
			}
			BSTNode parent = getParentOf(val);
			if (parent.lchild != null && parent.lchild.key.equals(val)) {
				parent.lchild = (removeThis.lchild != null) ? removeThis.lchild
						: removeThis.rchild;
			} else {
				parent.rchild = (removeThis.lchild != null) ? removeThis.lchild
						: removeThis.rchild;
			}
		} else {
			String successorKey = getSuccessor(removeThis);
			remove(successorKey);
			removeThis.key = successorKey;
		}
		return "Removed the val";
	}

	public String toString() {
		if (root == null)
			return "Empty";
		String val = inOrderTraversal(root);
		return val.substring(0, val.length() - 2) + "\n" + "Root is: "
				+ root.key;
	}

	private String inOrderTraversal(BSTNode node) {
		String leftVal = "";
		String currVal = "";
		String rightVal = "";
		if (node.lchild != null)
			leftVal = inOrderTraversal(node.lchild);
		currVal = node.key + ", ";
		if (node.rchild != null)
			rightVal = inOrderTraversal(node.rchild);
		return leftVal + currVal + rightVal;
	}

	private String getSuccessor(BSTNode removeThis) {
		BSTNode temp = removeThis.rchild;
		while (temp.lchild != null)
			temp = temp.lchild;
		return temp.key;
	}

	private BSTNode getParentOf(String val) {
		BSTNode current = root;
		BSTNode parent = null;
		while (!current.key.equals(val)) {
			parent = current;
			current = (current.key.compareTo(val) > 0) ? current.lchild
					: current.rchild;
		}
		return parent;
	}

	public static void main(String[] args) {
		// Try out the BST
		BST myBst = new BST();
		System.out.println("Insert a bunch of random values into BST:");
		for (int i = 0; i < 10; i += 1) {
			myBst.insert("" + (int) (Math.random() * 10));
		}
		System.out.println(myBst);
		System.out.println("Is 0 part of the tree?:");
		System.out.println(myBst.find("0") != null);
		System.out.println("Is 3 part of the tree?:");
		System.out.println(myBst.find("3") != null);
		System.out.println("Remove 0 from the tree:");
		myBst.remove("0");
		System.out.println(myBst);
		System.out.println("Remove 3 from the tree:");
		myBst.remove("3");
		System.out.println(myBst);
	}

}
