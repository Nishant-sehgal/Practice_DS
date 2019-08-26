package hackerrank.journey.to.moon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bfr.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int I = Integer.parseInt(temp[1]);

		Graph graph = new Graph(N);
		for (int i = 0; i < I; i++) {
			temp = bfr.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			graph.addEdge(a, b);
			// Store a and b in an appropriate data structure of your choice
		}

		long totalNoOfEdgesX = N;
		long totalNoOfEdgesY = N - 1;

		long totalNoOfEdges = (totalNoOfEdgesX * totalNoOfEdgesY) / 2;

		long connected = graph.getConnectedCount();

		long combinations = totalNoOfEdges - connected;

		// Compute the final answer - the number of combinations

		System.out.println(combinations);

	}
}

class Graph {
	private List<Integer> adjancyList[];

	@SuppressWarnings("unchecked")
	public Graph(int vertices) {
		this.adjancyList = new LinkedList[vertices];
		for (int i = 0; i < vertices; i++) {
			this.adjancyList[i] = new LinkedList<>();
		}
	}

	public void addEdge(int src, int destination) {
		this.adjancyList[src].add(destination);
		this.adjancyList[destination].add(src);
	}

	public long getConnectedCount() {
		Map<Integer, Integer> visited = new HashMap<>();
		long count = 0;
		long output = 0;
		for (int i = 0; i < adjancyList.length; i++) {
			if (!visited.containsKey(i)) {
				count = dfs(i, visited,count);
				output += (count * (count - 1)) / 2;
				count = 0;
			}
		}
		return output;
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
}