package com.qs;

public class FindWord {

	public static void main(String[] args) {
		char[][] ch = {
				{ 'A','B' },
				{ 'A','C' }};
		System.out.println(exist(ch, "ABC"));
	}

	public static boolean exist(char[][] board, String word) {
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (word(board, word, i, j, 0, "", visited) && !visited[i][j]) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean word(char[][] board, String word, int start, int end, int curChar, String wordSoFar,
			boolean[][] visited) {
		boolean ans = false;
		if (word.equals(wordSoFar)) {
			return true;
		}
		if (start >= board.length || start < 0 || end < 0 || end >= board[0].length) {
			return false;
		}
		if (visited[start][end]) {
			return false;
		}
		visited[start][end] = true;
		
		if (board[start][end] == word.charAt(curChar)) {
			wordSoFar += word.charAt(curChar);
			curChar++;
			ans = word(board, word, start + 1, end, curChar, wordSoFar, visited)
					|| word(board, word, start - 1, end, curChar, wordSoFar, visited)
					|| word(board, word, start, end + 1, curChar, wordSoFar, visited)
					|| word(board, word, start, end - 1, curChar, wordSoFar, visited);
		}
		visited[start][end] = false;
		return ans;
	}
}