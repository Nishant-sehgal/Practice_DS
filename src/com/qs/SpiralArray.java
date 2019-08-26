package com.qs;

public class SpiralArray {

	public static void main(String[] args) {
		int R = 3;
		int C = 6;
		int a[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };
		spiral(a, R, C);
	}

	public static void spiral(int[][] arr, int row, int col) {

		int rowVar = 0, colVar = 0;
		while (rowVar < row && col > colVar) {

			for (int i = colVar; i < col; i++) {
				System.out.println(arr[rowVar][i]);
			}
			rowVar++;
			for (int i = rowVar; i < row; i++) {
				System.out.println(arr[i][col - 1]);
			}
			col--;
			if (rowVar < row) {
				for (int i = col - 1; i >= colVar; i--) {
					System.out.println(arr[row - 1][i]);
				}

				row--;
			}
			if (col > colVar) {
				for (int i = row - 1; i >= rowVar; i--) {
					System.out.println(arr[i][colVar]);
				}
				colVar++;
			}
		}
	}
	public static void zigzag(int[][] arr, int row, int col){
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {

			}
			for (int j = 0; j < arr.length; j++) {

			}
		}
	}
}
