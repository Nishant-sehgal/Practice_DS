package com.datastructure.graph.undirected;

public class Main {

	public static void main(String[] args) {

		Graph graph = new Graph(10);
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 7, 8);
		graph.addEdge(1, 2, 8);
		graph.addEdge(1, 7, 11);
		graph.printGraph();
		/*
		 * graph.addEdge(2, new GraphNode(3, 7)); graph.addEdge(2, new
		 * GraphNode(8, 2)); graph.addEdge(2, new GraphNode(5, 4));
		 * graph.addEdge(3, new GraphNode(4, 9)); graph.addEdge(3, new
		 * GraphNode(5, 14)); graph.addEdge(4, new GraphNode(5, 10));
		 * graph.addEdge(5, new GraphNode(6, 2)); graph.addEdge(6, new
		 * GraphNode(7, 1)); graph.addEdge(6, new GraphNode(8, 6));
		 * graph.addEdge(7, new GraphNode(8, 7));
		 */

	}

}
