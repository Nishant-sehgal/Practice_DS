package com.datastructure.graph.snake;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadder {

	public static int getMinDiceThrows(int[] moves, int N) {

		boolean[] visited = new boolean[N];
		Queue<Node> queue = new LinkedList<Node>();
		visited[0] = true;
		queue.add(new Node(0, 0));
		Node node = null;
		while (!queue.isEmpty()) {
			node = queue.poll();
			int vertex = node.destination;

			if (vertex == N - 1) {
				break;
			}
			for (int i = vertex + 1; i < vertex + 6 && i < N; i++) {
				if (!visited[i]) {
					int destination = i;
					visited[i] = true;
					if (moves[i] != -1) {
						destination = moves[i];
					}
					Node n = new Node(destination, node.moves + 1);
					queue.add(n);
				}
			}
			System.out.println(queue);
		}
		return node.moves;
	}
}

class Node {

	/**
	 * @param destination
	 * @param moves
	 */
	public Node(int destination, int moves) {
		super();
		this.destination = destination;
		this.moves = moves;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Node [destination=" + destination + ", moves=" + moves + "]";
	}

	int destination;
	int moves;

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
	 * @return the moves
	 */
	public int getMoves() {
		return moves;
	}

	/**
	 * @param moves
	 *            the moves to set
	 */
	public void setMoves(int moves) {
		this.moves = moves;
	}

}