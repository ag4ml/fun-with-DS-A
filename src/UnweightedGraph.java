public class UnweightedGraph {

	/**
	 * Implementing a simple unweighted directed graph using an adjacency matrix
	 **/

	private boolean[][] adjMatrix;

	public UnweightedGraph(int numNodes) {
		this.adjMatrix = new boolean[numNodes][numNodes];
	}

	public void addEdge(int nodeA, int nodeB) {
		if (validNode(nodeA) && validNode(nodeB)) {
			adjMatrix[nodeA][nodeB] = true;
		}
	}

	public void removeEdge(int nodeA, int nodeB) {
		if (validNode(nodeA) && validNode(nodeB)) {
			adjMatrix[nodeA][nodeB] = false;
		}
	}

	public boolean isAdj(int nodeA, int nodeB) {
		return validNode(nodeA) && validNode(nodeB) && adjMatrix[nodeA][nodeB];
	}

	public String neighbors(int nodeA) {
		if (!validNode(nodeA))
			return "Invalid node!";
		String neighbors = "";
		for (int i = 0; i < adjMatrix.length; i += 1)
			neighbors += (adjMatrix[nodeA][i]) ? i + ", " : "";
		return neighbors.substring(0, neighbors.length() - 2);
	}

	public String addNewVertex() {
		boolean[][] newAdjMatrix = new boolean[adjMatrix.length + 1][adjMatrix.length + 1];
		for (int i = 0; i < adjMatrix.length; i += 1) {
			for (int j = 0; j < adjMatrix.length; i += 1) {
				newAdjMatrix[i][j] = adjMatrix[i][j];
			}
		}
		adjMatrix = newAdjMatrix;
		return "Added new vertex ( " + (adjMatrix.length - 1) + " )";
	}

	public String toString() {
		String view = "~\t";
		for (int i = 0; i < adjMatrix.length; i += 1)
			view += i + " ";
		view += "\n\n";
		for (int i = 0; i < adjMatrix.length; i += 1) {
			view += i + "\t";
			for (int j = 0; j < adjMatrix.length; j += 1) {
				view += (adjMatrix[i][j]) ? "1 " : "0 ";
			}
			view += "\n";
		}
		return view;
	}

	private boolean validNode(int nodeA) {
		return (0 <= nodeA && nodeA < adjMatrix.length);
	}

	public static void main(String[] args) {
		// try out the graph
		UnweightedGraph myGraph = new UnweightedGraph(5);
		System.out.println("Print out graph in initial state: ");
		System.out.println(myGraph);
		System.out.println("Update graph by adding edges: ");
		myGraph.addEdge(0, 2);
		myGraph.addEdge(3, 4);
		myGraph.addEdge(2, 3);
		myGraph.addEdge(3, 1);
		System.out.println(myGraph);
		System.out.println("What are the neighbors of node 3: ");
		System.out.println(myGraph.neighbors(3));
		System.out.println("Does the edge 0-2 exist?");
		System.out.println(myGraph.isAdj(0, 2));
		System.out.println("Remove the edge 0-2 if it exists: ");
		myGraph.removeEdge(0, 2);
		System.out.println(myGraph);
	}

}
