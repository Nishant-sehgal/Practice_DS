package hackerrank;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class BinarySerachIceCreamParlor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int m = in.nextInt();
			int n = in.nextInt();
			int a[] = new int[n];
			for (int a_i = 0; a_i < n; a_i++) {
				a[a_i] = in.nextInt();
			}
			findIceCreamId(m, n, a);
		}

	}

	public static String find(int index1, int index2, int[] duplicateArray) {
		StringJoiner joiner = new StringJoiner(" ");
		for (int i = 0; i < duplicateArray.length; i++) {
			if (duplicateArray[i] == index1 || duplicateArray[i] == index2) {
				joiner.add(i + 1 + "");
			}
		}
		return joiner.toString();
	}

	public static void findIceCreamId(int money, int noOfFlavours, int[] flavoursCost) {
		int[] duplicateArray = Arrays.copyOf(flavoursCost, flavoursCost.length);
		Arrays.sort(flavoursCost);
		int startIndex = 0, endIndex = flavoursCost.length;
		String sumVals = binarySearch(startIndex, endIndex - 1, flavoursCost, money);
		String[] arrVals = sumVals.split(" ");

		System.out.println(find(Integer.parseInt(arrVals[0]), Integer.parseInt(arrVals[1]), duplicateArray));

	}

	public static String binarySearch(int startIndex, int endIndex, int[] flavoursCost, int sum) {
		String indexString = "";
		while(startIndex<endIndex){
			if(flavoursCost[startIndex]+ flavoursCost[endIndex] > sum){
				endIndex--;
			}else if(flavoursCost[startIndex]+ flavoursCost[endIndex] < sum){
				startIndex++;
			}else{
				indexString =  flavoursCost[startIndex] + " " + flavoursCost[endIndex] ;
				break;
			}
		}
		return indexString;
	}

}
