package com.datastructure.graph.undirected;

public class GraphNode {

	private int weight;
	private GraphNode next;
	private int destination;

	public GraphNode(){}
	/**
	 * @param weight
	 * @param destination
	 */
	public GraphNode(int destination,int weight) {
		super();
		this.weight = weight;
		this.destination = destination;
	}
	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	/**
	 * @return the next
	 */
	public GraphNode getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(GraphNode next) {
		this.next = next;
	}
	/**
	 * @return the destination
	 */
	public int getDestination() {
		return destination;
	}
	/**
	 * @param destination the destination to set
	 */
	public void setDestination(int destination) {
		this.destination = destination;
	}
}
