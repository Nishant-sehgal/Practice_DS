package hackerrank.roads.library;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int x = in.nextInt();
			int y = in.nextInt();
			Graph graph = new Graph(n, x, y);
			for (int a1 = 0; a1 < m; a1++) {
				int city_1 = in.nextInt();
				int city_2 = in.nextInt();
				graph.addEdge(city_1, city_2);
			}
			graph.printCost();
		}

		in.close();
	}
}

class Graph {
	private List<Integer> adjancyList[];
	private long costOfLibrary;
	private long costOfRoad;
	private long vertices;

	@SuppressWarnings("unchecked")
	public Graph(int vertices, int costOfLibrary, int costOfRoad) {
		this.adjancyList = new LinkedList[vertices+1];
		this.costOfLibrary = costOfLibrary;
		this.vertices = vertices;
		this.costOfRoad = costOfRoad;
		for (int i = 1; i < vertices+1; i++) {
			this.adjancyList[i] = new LinkedList<>();
		}
	}

	public void addEdge(int src, int destination) {
		this.adjancyList[src].add(destination);
		this.adjancyList[destination].add(src);
	}

	public void printCost() {
		long cost = 0;
		if (this.costOfRoad > this.costOfLibrary) {
			cost = this.costOfLibrary * this.vertices;
			System.out.println(cost);
			return;
		} else {
			Map<Integer, Integer> visited = new HashMap<>();
			long count = 0;
			long output = 0;
			for (int i = 1; i < adjancyList.length; i++) {
				if (!visited.containsKey(i)) {
					count = dfs(i, visited, count);
					output += ((count -1) * this.costOfRoad) + this.costOfLibrary;
					count = 0;
				}
			}
			System.out.println(output);
		}
	}

	public long dfs(Integer i, Map<Integer, Integer> visited, long count) {
		visited.put(i, i);
		count++;
		for (Integer nodeValue : this.adjancyList[i]) {
			if (!visited.containsKey(nodeValue)) {
				visited.put(nodeValue, nodeValue);
				count = dfs(nodeValue, visited, count);
			}
		}
		return count;
	}

	/**
	 * @return the adjancyList
	 */
	public List<Integer>[] getAdjancyList() {
		return adjancyList;
	}

	/**
	 * @param adjancyList
	 *            the adjancyList to set
	 */
	public void setAdjancyList(List<Integer>[] adjancyList) {
		this.adjancyList = adjancyList;
	}

	/**
	 * @return the costOfLibrary
	 */
	public long getCostOfLibrary() {
		return costOfLibrary;
	}

	/**
	 * @param costOfLibrary
	 *            the costOfLibrary to set
	 */
	public void setCostOfLibrary(long costOfLibrary) {
		this.costOfLibrary = costOfLibrary;
	}

	/**
	 * @return the costOfRoad
	 */
	public long getCostOfRoad() {
		return costOfRoad;
	}

	/**
	 * @param costOfRoad
	 *            the costOfRoad to set
	 */
	public void setCostOfRoad(long costOfRoad) {
		this.costOfRoad = costOfRoad;
	}

	/**
	 * @return the vertices
	 */
	public long getVertices() {
		return vertices;
	}

	/**
	 * @param vertices
	 *            the vertices to set
	 */
	public void setVertices(long vertices) {
		this.vertices = vertices;
	}

}