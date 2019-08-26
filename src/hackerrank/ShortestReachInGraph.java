package hackerrank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * Undirected graph with equal weight
 *
 * @author MMT5680
 *
 */
public class ShortestReachInGraph {
	private static int GRAPH_WEIGHT = 6;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfQueries = in.nextInt();
		List<Graph> listOfGraphs = new ArrayList<>(noOfQueries);
		for (int i = 0; i < noOfQueries; i++) {
			int noOfVertices = in.nextInt() + 1;
			int noOfEdges = in.nextInt();
			Graph graph = new Graph(noOfVertices);
			for (int j = 0; j < noOfEdges; j++) {
				graph.addEdge(in.nextInt(), in.nextInt(), GRAPH_WEIGHT);
			}

			int startingNode = in.nextInt();
			graph.setStartingPoint(startingNode);
			listOfGraphs.add(graph);
		}
		in.close();
		for (Graph graph : listOfGraphs) {
			graph.shortestDistance(graph.getStartingPoint(), graph.getVertices());
		}

	}

}

class Graph {
	private List<Node> adjancyList;
	private int startingPoint;
	private int vertices;

	public Graph(int vertices) {
		this.vertices = vertices;
		this.adjancyList = new ArrayList<Node>(vertices);
		for (int i = 0; i < vertices; i++) {
			this.adjancyList.add(null);
		}
	}

	public void addEdge(int src, int destination, int weight) {
		Node existingSrcNode = adjancyList.get(src);
		Node existingDestNode = adjancyList.get(destination);
		Node srcnode = new Node(destination, weight);
		srcnode.setParent(src);
		Node destNnode = new Node(src, weight);
		destNnode.setParent(destination);
		if (null != existingSrcNode) {
			srcnode.setNext(existingSrcNode);
		}
		adjancyList.set(src, srcnode);

		if (null != existingDestNode) {
			destNnode.setNext(existingDestNode);
		}
		adjancyList.set(destination, destNnode);
	}

	public void shortestDistance(int startingVertex, int vertices) {
		int[] visitedNodes = new int[vertices];
		int[] distanceOfNodes = new int[vertices];
		int[] parent = new int[vertices];
		for (int i = 0; i < vertices; i++) {
			visitedNodes[i] = 0;
			distanceOfNodes[i] = -1;
			parent[i] = 0;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(this.adjancyList.get(startingVertex));
		visitedNodes[startingVertex] = 1;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			while (node != null) {
				if (visitedNodes[node.getDestination()] == 0) {
					parent[node.getDestination()] = node.getParent();
					queue.add(this.adjancyList.get(node.getDestination()));
					visitedNodes[node.getDestination()] = 1;
					if (distanceOfNodes[node.getParent()] == -1) {
						distanceOfNodes[node.getDestination()] = 6;
					} else {
						distanceOfNodes[node.getDestination()] = 6 + distanceOfNodes[node.getParent()];
					}
					node = node.getNext();
				} else {
					node = node.getNext();
				}
			}
		}
		for (int i = 1; i < distanceOfNodes.length; i++) {
			if (startingVertex != i) {
				System.out.print(distanceOfNodes[i]);
				System.out.print(" ");
			}
		}
		System.out.println();
	}

	/**
	 * @return the adjancyList
	 */
	public List<Node> getAdjancyList() {
		return adjancyList;
	}

	/**
	 * @param adjancyList
	 *            the adjancyList to set
	 */
	public void setAdjancyList(List<Node> adjancyList) {
		this.adjancyList = adjancyList;
	}

	/**
	 * @return the startingPoint
	 */
	public int getStartingPoint() {
		return startingPoint;
	}

	/**
	 * @param startingPoint
	 *            the startingPoint to set
	 */
	public void setStartingPoint(int startingPoint) {
		this.startingPoint = startingPoint;
	}

	/**
	 * @return the vertices
	 */
	public int getVertices() {
		return vertices;
	}

	/**
	 * @param vertices
	 *            the vertices to set
	 */
	public void setVertices(int vertices) {
		this.vertices = vertices;
	}

}

class Node {
	private int parent;
	private int weight;
	private int destination;
	private Node next;

	public Node(int destination, int weight) {
		this.destination = destination;
		this.weight = weight;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return the next
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * @param next
	 *            the next to set
	 */
	public void setNext(Node next) {
		this.next = next;
	}

	/**
	 * @return the destination
	 */
	public int getDestination() {
		return destination;
	}

	/**
	 * @param destination
	 *            the destination to set
	 */
	public void setDestination(int destination) {
		this.destination = destination;
	}

	/**
	 * @return the parent
	 */
	public int getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(int parent) {
		this.parent = parent;
	}

}
