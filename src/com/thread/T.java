package com.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T {
	static int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static boolean search2D(char[][] grid, int row, int col, String word, int R, int C, int index, boolean[][] vis) {
		if (row >= R || row < 0 || col >= C || col < 0 || vis[row][col]) {
			return false;
		}
		if (word.length() == index+1) {
			return true;
		}
		if (grid[row][col] != word.charAt(index))
			return false;

		vis[row][col] = true;
		for (int dir = 0; dir < 8; dir++) {
			int rd = row + x[dir], cd = col + y[dir];
			boolean x = search2D(grid, rd, cd, word, R, C, index + 1, vis);
			if (x) {
				return true;
			}
		}
		vis[row][col] = false;
		return false;
	}

	static boolean patternSearch(char[][] grid, String word, int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				boolean[][] vis = new boolean[row][col];
				if (search2D(grid, i, j, word, row, col, 0, vis)) {
					return true;
				}

			}
		}
		return false;
	}

	public static void main(String args[]) throws Exception {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT
		 */
		Scanner scanner = new Scanner(System.in);
		int wordLen = scanner.nextInt();
		List<String> words = new ArrayList<String>();
		for (int i = 0; i < wordLen; i++) {
			String str = scanner.next();
			words.add(str);
		}
		int row = scanner.nextInt();
		int col = scanner.nextInt();
		char[][] grid = new char[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				char ch = scanner.next().charAt(0);
				grid[i][j] = ch;
			}

		}
		scanner.close();
		int count = 0;
		for (int i = 0; i < words.size(); i++) {
			if (patternSearch(grid,words.get(i), row, col)) {
				count++;
			}
		}
		System.out.println(count);
	}
}
