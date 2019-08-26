package com.thread;

import java.util.Scanner;
import java.util.Set;

public class Intuit {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int z = 0; z < n; z++) {
			int rows = scanner.nextInt();
			int cols = scanner.nextInt();
			int ans = 0;
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {				
					if ((j + 1) % (i + 1) == 0) {
						ans += 1;
					}
				}
			}
			System.out.println(ans);
		}		

		/*
		 * Scanner scanner = new Scanner(System.in); int n = scanner.nextInt();
		 * Set<String> words = new HashSet<>(); for (int z = 0; z < n; z++) {
		 * String input = scanner.next(); words.add(input); }
		 * 
		 * int i = scanner.nextInt(); int j = scanner.nextInt(); char[][] matrix
		 * = new char[i][j];
		 * 
		 * for (int k = 0; k < i; k++) { for (int l = 0; l < j; l++) {
		 * matrix[k][l] = scanner.next().charAt(0); } } scanner.close();
		 * count(words, matrix);
		 */
	}

	public static void count(Set<String> words, char[][] matrix) {
		String word = "INTUIT";

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				boolean[][] visited = new boolean[matrix.length][matrix[0].length];
				search(matrix, row, col, matrix.length, matrix[0].length, word, visited, 0);
			}
		}
		System.out.println(count);
	}

	static int count = 0;

	static boolean isSafe(char matrix[][], int row, int col, int ROW, int COL, boolean visited[][]) {
		return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && !visited[row][col];
	}

	static void search(char[][] grid, int row, int col, int R, int C, String word, boolean[][] visited, int index) {
		if (grid[row][col] != word.charAt(0))
			return;

		int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
		int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
		index++;
		// Mark this cell as visited
		visited[row][col] = true;

		for (int k = 0; k < 8; ++k) {
			if (isSafe(grid, row + rowNbr[k], col + colNbr[k], grid.length, grid[0].length, visited)
					&& grid[row + rowNbr[k]][col + colNbr[k]] == word.charAt(index)) {
				search(grid, row + rowNbr[k], col + colNbr[k], grid.length, grid[0].length, word, visited, index++);
			}
			if (index == word.length()) {
				count++;
				return;
			}

		}
	}

}
