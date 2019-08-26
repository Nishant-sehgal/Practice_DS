package com.hackerrank.queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class Node {
	public int dist;
	public String dir;
	public int x;
	public int y;

	public Node(int dist, int x, int y, String dir) {
		super();
		this.dist = dist;
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

}

public class MinimumMoves {

	static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
		Queue<Node> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		queue.add(new Node(0, startX, startY, "INITIAL"));
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			visited.add(temp.x + "-" + temp.y);
			if (temp.x == goalX && temp.y == goalY) {
				return temp.dist;
			}

			// left
			int left = temp.y - 1;
			while(left>= 0 && isSafe(grid, temp.x, left, visited)) {
				int d = temp.dist;
				if (!temp.dir.equalsIgnoreCase("LEFT")) {
					d = temp.dist + 1;
				}
				queue.add(new Node(d, temp.x, left, "LEFT"));
				left--;
			}
			// right
			int right = temp.y + 1;
			while(right< grid.length && isSafe(grid, temp.x, right, visited)) {
				int d = temp.dist;
				if (!temp.dir.equalsIgnoreCase("RIGHT")) {
					d = temp.dist + 1;
				}
				queue.add(new Node(d, temp.x, right, "RIGHT"));
				right++;
			}
			// up
			int up =  temp.x - 1;
			while (up>=0 && isSafe(grid, up, temp.y, visited)) {
				int d = temp.dist;
				if (!temp.dir.equalsIgnoreCase("UP")) {
					d = temp.dist + 1;
				}
				queue.add(new Node(d, up, temp.y, "UP"));
				up--;
			}
			// down
			int down = temp.x + 1;
			while (down <= grid.length && isSafe(grid, down, temp.y, visited)) {
				int d = temp.dist;
				if (!temp.dir.equalsIgnoreCase("DOWN")) {
					d = temp.dist + 1;
				}
				queue.add(new Node(d, down, temp.y, "DOWN"));
				down++;
			}
		}
		return -1;
	}

	public static boolean isSafe(String[] grid, int startX, int startY, Set<String> visited) {

		if (startX >= 0 && startX < grid.length && startY >= 0 && startY < grid.length
				&& grid[startX].charAt(startY) == '.' && !visited.contains(startX + "-" + startY)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] grid = new String[n];
		for (int grid_i = 0; grid_i < n; grid_i++) {
			grid[grid_i] = in.next();
		}
		int startX = in.nextInt();
		int startY = in.nextInt();
		int goalX = in.nextInt();
		int goalY = in.nextInt();
		int result = minimumMoves(grid, startX, startY, goalX, goalY);
		System.out.println(result);
		in.close();
	}

}
