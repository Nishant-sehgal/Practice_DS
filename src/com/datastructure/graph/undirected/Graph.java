package com.datastructure.graph.undirected;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	private int noOfVertices;
	private List<GraphNode> adjancyList;

	public Graph(int vertices) {
		this.noOfVertices = vertices;
		adjancyList = new ArrayList<GraphNode>(vertices);
		for (int i = 0; i < vertices; i++) {
			adjancyList.add(null);
		}
	}

	public void addEdge(int src, int dest, int weight) {
		GraphNode nodeSrc = new GraphNode(src, weight);
		GraphNode nodeDest = new GraphNode(dest, weight);
		GraphNode srcCurrentNode = adjancyList.get(src);
		GraphNode destCurrentNode = adjancyList.get(dest);

		if (null != srcCurrentNode) {
			nodeDest.setNext(srcCurrentNode);
		}
		adjancyList.set(src, nodeDest);

		if (null != destCurrentNode) {
			nodeSrc.setNext(destCurrentNode);
		}
		adjancyList.set(dest, nodeSrc);

	}

	public void printGraph() {
		for (int i = 0; i < adjancyList.size(); i++) {
			GraphNode node = adjancyList.get(i);
			while (node != null) {
				System.out.print(i + "---------" + node.getDestination());
				node = node.getNext();
				System.out.print("\t");
			}
			System.out.println();
		}
	}

	/**
	 * @return the noOfVertices
	 */
	public int getNoOfVertices() {
		return noOfVertices;
	}

	/**
	 * @return the adjancyList
	 */
	public List<GraphNode> getAdjancyList() {
		return adjancyList;
	}

	/**
	 * @param adjancyList
	 *            the adjancyList to set
	 */
	public void setAdjancyList(List<GraphNode> adjancyList) {
		this.adjancyList = adjancyList;
	}

	/**
	 * @param noOfVertices
	 *            the noOfVertices to set
	 */
	public void setNoOfVertices(int noOfVertices) {
		this.noOfVertices = noOfVertices;
	}

}
