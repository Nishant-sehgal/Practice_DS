package com.qs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {

		Set<String> dictionary = new HashSet<>();
		dictionary.add("poon");
		dictionary.add("plee");
		dictionary.add("same");
		dictionary.add("poie");
		dictionary.add("plie");
		dictionary.add("poin");
		dictionary.add("plea");
		System.out.println(wordLadder("toon", "plea", dictionary));

	}

	public static int wordLadder(String source, String target, Set<String> dictionary) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(source, 1));

		while (!q.isEmpty()) {
			Node val = q.poll();
			Iterator<String> itr = dictionary.iterator();
			while (itr.hasNext()) {
				String word = itr.next();
				if (isIdentical(val.item, word)) {
					q.add(new Node(word, val.length + 1));
					itr.remove();

					if (word == target) {
						return val.length + 1;
					}
				}

			}
		}
		return 0;
	}

	private static boolean isIdentical(String item, String dictinaryWord) {
		int diff = 0, i = 0;
		while (i < item.length()) {
			if (item.charAt(i) != dictinaryWord.charAt(i)) {
				diff++;
			}
			i++;
		}
		if (diff == 1) {
			return true;
		}
		return false;
	}
}

class Node {
	String item;
	int length;

	/**
	 * @param item
	 * @param length
	 */
	public Node(String item, int length) {
		super();
		this.item = item;
		this.length = length;
	}

}
