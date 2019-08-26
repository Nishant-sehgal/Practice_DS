package hackerrank.heap.basic;

import java.util.Scanner;

public class Solution {

	private static int[] arr = new int[100000];
	private static int counter = 0;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int size = scn.nextInt();
		for (int i = 0; i < size; i++) {
			int op = scn.nextInt();
			int val = 0;
			if (op == 1 || op == 2) {
				val = scn.nextInt();
			}
			if (op == 1) {
				add(val);
			} else if (op == 3) {
				print();
			} else if (op == 2) {
				delete(val);
			}
		}
		scn.close();
	}

	public static void add(int val) {
		arr[++counter] = val;
		upheap(arr, counter);
		//System.out.println("Add : "+Arrays.toString(arr));
	}


	public static void upheap(int[] arr, int start) {
		if (start > 1) {
			int parent = start / 2;
			if (arr[start] < arr[parent]) {
				int temp = arr[parent];
				arr[parent] = arr[start];
				arr[start] = temp;
				upheap(arr, parent);
			}
		}
	}

	public static void print() {
		System.out.println(arr[1]);
	}

	public static void delete(int val) {
		int start= 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == val) {
				arr[i] = arr[counter];
				arr[counter] = 0;
				counter--;
				start = i;
				break;
			}
		}
		downheap(arr, start);
		//System.out.println("Delete : "+Arrays.toString(arr));
	}

	public static void downheap(int[] arr, int start) {
		if (start <= counter) {
			int left = 2 * start;
			int right = left + 1;
			boolean flag = false;
			if (arr[start] > arr[right] && right<=counter) {
				int temp = arr[start];
				arr[start] = arr[right];
				arr[right] = temp;
				flag = true;
			}
			if (arr[start] > arr[left] && left<=counter) {
				int temp = arr[start];
				arr[start] = arr[left];
				arr[left] = temp;
				flag = true;
			}
			if(flag){
			downheap(arr, start*2);
			}
		}
	}

}
