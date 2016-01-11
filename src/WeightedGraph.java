import java.util.ArrayList;
import java.util.HashMap;

public class WeightedGraph {

	/** Implementing a weighted directed graph using an adjacency list **/

	private class Node {

		/** A class to reprsent a node in a graph **/

		String id;
		HashMap<String, Integer> adjList;

		public Node(String identity) {
			this.id = identity;
			adjList = new HashMap<String, Integer>();
		}
	}

	private ArrayList<Node> graph;

	public WeightedGraph() {
		this.graph = new ArrayList<Node>();
	}

	public void addEdge(String id1, String id2, int weight) {
		int first = findNode(id1);
		int second = findNode(id2);
		if (first == -1 || second == -1)
			return;
		graph.get(first).adjList.put(id2, weight);
	}

	public void removeEdge(String id1, String id2) {
		int first = findNode(id1);
		int second = findNode(id2);
		if (first != -1 && second != -1)
			graph.get(first).adjList.remove(id2);
	}

	public void addNode(String id) {
		graph.add(new Node(id));
	}

	public void removeNode(String id) {
		int index = findNode(id);
		if (index == -1)
			return;
		graph.remove(index);
		for (Node n : graph)
			n.adjList.remove(id);
	}

	public boolean isAdj(String id1, String id2) {
		int first = findNode(id1);
		int second = findNode(id2);
		return (first != -1 && second != -1) ? graph.get(first).adjList
				.containsKey(id2) : false;
	}

	public String neighbors(String id) {
		String neighbors = "";
		int index = findNode(id);
		if (index == -1)
			return neighbors;
		for (String n : graph.get(index).adjList.keySet())
			neighbors += n + ", ";
		return neighbors.substring(0, neighbors.length() - 2);
	}

	public String getEdge(String id1, String id2) {
		int first = findNode(id1);
		int second = findNode(id2);
		if (first == -1 || second == -1)
			return "Not a valid edge";
		return (graph.get(first).adjList.containsKey(id2)) ? graph.get(first).adjList
				.get(id2) + ""
				: "Not a valid edge";
	}

	public void setEdge(String id1, String id2, int weight) {
		int first = findNode(id1);
		int second = findNode(id2);
		if (first != -1 && second != -1
				&& graph.get(first).adjList.containsKey(id2))
			graph.get(first).adjList.put(id2, weight);
	}

	public String toString() {
		String view = "";
		for (Node n : graph) {
			view += n.id + ": ";
			for (String neighbor : n.adjList.keySet()) {
				view += neighbor;
				view += (n.adjList.get(neighbor) != 0) ? "("
						+ n.adjList.get(neighbor) + ")" : "";
				view += ", ";
			}
			view = view.substring(0, view.length() - 2);
			view += "\n";
		}
		return view;
	}

	private int findNode(String id) {
		for (int i = 0; i < graph.size(); i += 1)
			if (graph.get(i).id.equals(id))
				return i;
		return -1;
	}

	public static void main(String[] args) {
		// try out the graph
		WeightedGraph myG = new WeightedGraph();
		System.out.println("Add 5 nodes: ");
		for (int i = 0; i < 5; i += 1)
			myG.addNode(i + "");
		System.out.println(myG);
		System.out.println("Add 25 random edges with random edge weights: ");
		for (int i = 0; i < 25; i += 1) {
			String node1 = "" + (int) (Math.random() * 5);
			String node2 = "" + (int) (Math.random() * 5);
			int weight = (int) (Math.random() * 10);
			myG.addEdge(node1, node2, weight);
		}
		System.out.println(myG);
		System.out.println("What is the edge weight 1-0?");
		System.out.println(myG.getEdge("1", "0"));
		System.out.println("Set that edge to 99");
		myG.setEdge("1", "0", 99);
		System.out.println(myG);
		System.out.println("Now remove the 0th node: ");
		myG.removeNode("0");
		System.out.println(myG);
		System.out.println("Who are 4's neighbors?: ");
		System.out.println(myG.neighbors("4"));

	}

}
