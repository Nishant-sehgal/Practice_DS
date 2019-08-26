package com.array;

public class ShuffleArray {

	static void shuffleArray(int a[], int n)
    {
        // Rotate the element to the left
        for (int i = 0, q = 1, k = n; i < n; i++, k++, q++)
            for (int j = k; j > i + q; j--){
                // swap a[j-1], a[j]
                int temp = a[j-1];
                a[j-1] = a[j];
                a[j] = temp;
            }
    }
	public static void main(String[] args){
		int a[] = { 1, 3, 5, 7, 2, 4, 6, 8 };

        shuffleArray(a, a.length/2);
	}
}
