package com.program;

import java.util.Random;

public class MissingElement {

	public static void main(String[] args) {

		int arr[] = new int[300];
		int val = 1;
		for (int i = 0; i < arr.length; i += 3) {
			arr[i] = val;
			arr[i + 1] = val;
			arr[i + 2] = val;
			val++;
		}

		int indexA = new Random().nextInt(300);
		int indexB = new Random().nextInt(300);

		System.out.println("Missing index:" + indexA);
		System.out.println("Missing index:" + indexB);
		int newArr[] = new int[298];
		int j = 0;
		for (int i = 0; i < newArr.length; i++) {
			/*if (i == indexA && i+1 == indexB){
				j +=2;
				newArr[i] = arr[j];
			}
			else */if (i == indexA || i == indexB) {
				newArr[i] = arr[j++];
			} else {
				newArr[i] = arr[j];
			}
			j++;
		}
		System.out.println("Original Array");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
		System.out.println("New Array");
		for (int i = 0; i < newArr.length; i++) {
			System.out.print(newArr[i] + "\t");
		}
		findMissingElement(new int[]{1,1,1,2,2,2,3,3,3}, new int[]{1,1,2,2,2,3,3}, 0,9);
		/*findMissingElement(arr, newArr, 0,300);*/
	}

	public static void findMissingElement(int[] arr, int[] newArr, int beg, int end) {
		int mid = 0;
		while (beg < end) {
			mid = (beg + end) / 2;
			if(beg + end <2){
				System.out.println("nothing");
			}
			else if(beg + end == 2){
				if(arr[mid] == newArr[mid]){
					System.out.println();
					System.out.println("Missing Element:"+arr[mid]);
				}else if(arr[mid] != newArr[mid]){
					System.out.println();
					System.out.println("Missing Element:"+arr[mid -1]);
					System.out.println("Missing Element:"+arr[mid -1]);
				}else{
					System.out.println("nthing");
				}
			}
			else if (newArr[mid] == arr[mid] && newArr[mid + 1] == arr[mid + 1] && newArr[mid + 2] == arr[mid + 2]) {
				findMissingElement(arr, newArr, mid + 3,end);
			} else {
				if(arr[mid +1] == newArr[mid] && arr[mid +2] == newArr[mid+1] && arr[mid +3] == newArr[mid+2]){
					findMissingElement(arr, newArr,beg,mid-1);
					findMissingElement(arr, newArr, mid + 1,end);
				}else if(arr[mid +2] == newArr[mid] && arr[mid +3] == newArr[mid+1] && arr[mid +4] == newArr[mid+2]){
					findMissingElement(arr, newArr, beg,mid);
				}
			}
		}
	}

}
