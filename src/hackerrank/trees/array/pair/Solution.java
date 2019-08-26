package hackerrank.trees.array.pair;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<BigInteger> bigIntegerList = new ArrayList<BigInteger>();
		for (int i = 0; i < n; i++) {
			bigIntegerList.add(scanner.nextBigInteger());
		}
		System.out.println(getPairCount(bigIntegerList));
		scanner.close();

	}

	private static BigInteger getPairCount(List<BigInteger> bigIntegerList) {
		BigInteger pairCounter = new BigInteger("0");
		for (int i = 0; i < bigIntegerList.size() - 1; i++) {
			BigInteger maxCount = bigIntegerList.get(i);
			for (int j = i + 1; j < bigIntegerList.size(); j++) {
				BigInteger pair = bigIntegerList.get(i).multiply(bigIntegerList.get(j));
				if (maxCount.compareTo(bigIntegerList.get(j)) < 0) {
					maxCount = bigIntegerList.get(j);
				}
				if (pair.compareTo(maxCount) <= 0) {
					System.out.print(bigIntegerList.get(i) + " " + bigIntegerList.get(j) + ":");
					System.out.println(pair);
					pairCounter = pairCounter.add(new BigInteger("1"));
				}
			}
		}
		return pairCounter;
	}
}