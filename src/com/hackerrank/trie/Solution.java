package com.hackerrank.trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static Map<String, Trie> referenceMap = new HashMap<>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Trie trie = new Trie();
		long startTime = System.currentTimeMillis();
		for (int a0 = 0; a0 < n; a0++) {
			String op = in.next();
			String contact = in.next();
			if ("add".equals(op)) {
				add(contact, trie);
			} else if ("find".equals(op)) {
				search(trie, contact);
			}
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		//System.out.println(totalTime);
		in.close();
	}

	public static void add(String input, Trie trie) {
		Trie triRef = trie;
		boolean repeatFlag = true;
		for (int i = 0; i < input.length(); i++) {
			Character inputChar = input.charAt(i);
			if (repeatFlag) {
				if (triRef.getTrieNode().containsKey(inputChar)) {
					triRef = triRef.getTrieNode().get(inputChar);
					triRef.setCount(triRef.getCount() + 1);
					continue;
				} else {
					repeatFlag = false;
				}
			}

			triRef.getTrieNode().put(inputChar, new Trie());
			triRef = triRef.getTrieNode().get(inputChar);
		}
		triRef.setCompleted(true);
		 //System.out.println(Arrays.asList(trie));
	}

	public static void search(Trie trie, String searchStr) {
		boolean found = false;
		if (referenceMap.containsKey(searchStr)) {
			trie = referenceMap.get(searchStr);
			found = true;
		} else {
			for (int i = 0; i < searchStr.length(); i++) {
				Character str = searchStr.charAt(i);
				if (trie.getTrieNode().containsKey(str)) {
					trie = trie.getTrieNode().get(str);
					found = true;
				} else {
					found = false;
					break;
				}
			}
		}
		if (found) {
			//System.out.println(getWordCount(trie, 0));
			System.out.println(trie.getCount());
			referenceMap.put(searchStr, trie);
		} else {
			System.out.println(0);
		}
	}

	public static int getWordCount(Trie trie, int count) {
		if (trie.isCompleted()) {
			count++;
		}
		for (Character ch : trie.getTrieNode().keySet()) {
			count = getWordCount(trie.getTrieNode().get(ch), count);
		}
		return count;
	}
}

class Trie {
	private Map<Character, Trie> trieNode;
	private boolean isCompleted;
	private int count =1;

	public Trie() {
		this.trieNode = new HashMap<>();
	}

	/**
	 * @return the trieNode
	 */
	public Map<Character, Trie> getTrieNode() {
		return trieNode;
	}

	/**
	 * @param trieNode
	 *            the trieNode to set
	 */
	public void setTrieNode(Map<Character, Trie> trieNode) {
		this.trieNode = trieNode;
	}

	/**
	 * @return the isCompleted
	 */
	public boolean isCompleted() {
		return isCompleted;
	}

	/**
	 * @param isCompleted
	 *            the isCompleted to set
	 */
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Trie [trieNode=" + trieNode + ", isCompleted=" + isCompleted + ", count=" + count + "]";
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

}