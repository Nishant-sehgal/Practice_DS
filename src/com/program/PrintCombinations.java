package com.program;

public class PrintCombinations {

	//Print all combinations of points that can compose a given number
	public static void main(String[] args) {
		int[] a = new int[4];
		printCombinations(4, 0, a);
	}

	public static void printCombinations(int number, int startIndex, int[] refrenceArray) {
		int arr[] = refrenceArray;
		if (number == 0) {
			for (int i = 0; i < startIndex; i++) {
				System.out.print(arr[i] + "\t");
			}
			System.out.println();
		} else if (number > 0) {
			for (int i = 1; i <= number; i++) {
				arr[startIndex] = i;
				printCombinations(number - i, startIndex + 1, arr);
			}
		}
	}

}
