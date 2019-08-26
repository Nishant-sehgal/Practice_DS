package com.hackerrank.code.week35;

import java.util.Scanner;

public class TripleRecursion {

	static void tripleRecursion(int n, int m, int k) {
		int[][] a = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i==0 && j==0){
					a[0][0] = m;
				}
				else if(i == j){
					a[i][j] = a[i-1][j-1]+k;
				}
				else if(i>j){
					a[i][j] = a[i-1][j]-1;
				}else{
					a[i][j] = a[i][j-1]-1;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        tripleRecursion(n, m, k);
        in.close();
    }

}
