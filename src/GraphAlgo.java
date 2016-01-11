import java.util.ArrayList;

public class GraphAlgo {

	/** A simple class to host graph algorithms **/

	private ArrayList<Integer>[] graph;
	private String[] colors;

	public GraphAlgo(int numNodes) {
		this.graph = (ArrayList<Integer>[]) new ArrayList[numNodes];
		for (int i = 0; i < numNodes; i++)
			this.graph[i] = new ArrayList<Integer>();
		this.colors = new String[numNodes];
		for (int i = 0; i < colors.length; i += 1)
			colors[i] = "white";
	}

	public void addEdge(int source, int dest) {
		if (validNode(source) && validNode(dest)) {
			if (!graph[source].contains(dest))
				graph[source].add(dest);
			if (!graph[dest].contains(source))
				graph[dest].add(source);
		}
	}

	public void breadthFirstSearch(int source) {
		if (!validNode(source))
			return;
		colors[source] = "gray";
		ArrayList<Integer> queue = new ArrayList<Integer>();
		queue.add(source);
		String view = "Processed: ";
		while (!queue.isEmpty()) {
			int current = queue.remove(0);
			for (int child : graph[current]) {
				if (colors[child].equals("white")) {
					colors[child] = "gray";
					queue.add(child);
				}
			}
			colors[current] = "black";
			view += current + ", ";
		}
		System.out.println(view.substring(0, view.length() - 2));
	}

	public void depthFirstSearch(int node) {
		colors[node] = "gray";
		for (int child : graph[node]) {
			if (colors[child].equals("white"))
				depthFirstSearch(child);
		}
		colors[node] = "black";
		System.out.println("Processed: " + node);
	}

	private boolean validNode(int node) {
		return (0 <= node) && (node < graph.length);
	}

	public void undiscover() {
		for (int i = 0; i < colors.length; i += 1)
			colors[i] = "white";
	}

	public static void main(String[] args) {
		// Try out the algos
		GraphAlgo myGraph = new GraphAlgo(6);
		myGraph.addEdge(0, 1);
		myGraph.addEdge(0, 2);
		myGraph.addEdge(1, 3);
		myGraph.addEdge(2, 4);
		myGraph.addEdge(2, 5);
		System.out.println("Do a BFS traversal from 0: ");
		myGraph.breadthFirstSearch(0);
		myGraph.undiscover();
		System.out.println("Do a DFS traversal from 0: ");
		myGraph.depthFirstSearch(0);

	}

}
