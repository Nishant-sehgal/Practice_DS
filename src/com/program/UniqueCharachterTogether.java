package com.program;

public class UniqueCharachterTogether {

	public static void main(String[] args) {
		// all unique chars of given string should appears together

		// gol gol

		// agooglea:true google:true googleaaaa:true gogogole:true gogole:true
		// golgole:true
		// golglego
		// agoogleloa
		// golglego  googleelgola
		System.out.println(uniqueCombination("golgologoelgoea"));
	}

	public static boolean uniqueCombination(String input) {
		int[] visited = new int[256];
		String uniqueString = "";
		int startIndex = 0, endIndex = input.length(), uniqueLength = 0;
		while (startIndex < endIndex) {
			if (visited[input.charAt(startIndex)] == 0) {
				visited[input.charAt(startIndex)] = ++visited[input.charAt(startIndex)];
				uniqueString += input.charAt(startIndex);
				uniqueLength++;
			}
			startIndex++;
		}
		System.out.println("Unique String::" + uniqueString);
		System.out.println("Unique String Length::" + uniqueLength);
		return printUniqueCombinations(input, 0, endIndex, new char[endIndex], uniqueLength);
	}

	public static boolean printUniqueCombinations(String input, int startIndex, int endIndex, char[] combinations,
			int uniqueLength) {
		int index = 0, lastIndex = 0;
		int[] tempArr = new int[256];

		while (startIndex < endIndex) {
			combinations[index++] = input.charAt(startIndex);
			if (tempArr[input.charAt(startIndex)] > 0) {
				startIndex = ++lastIndex;
				index = 0;
				tempArr = new int[256];
			} else if (index == uniqueLength) {
				startIndex = ++lastIndex;
				index = 0;
				tempArr = new int[256];
				for (int i = 0; i < combinations.length; i++) {
					System.out.print(combinations[i] + "\t");
				}
				System.out.println();
				return true;
			} else {
				tempArr[input.charAt(startIndex)] = ++tempArr[input.charAt(startIndex)];
				startIndex++;
			}
		}
		return false;
	}

}
