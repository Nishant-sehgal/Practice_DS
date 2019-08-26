package com.hackerrank.trie.noprefixset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Trie trie = new Trie();
		for (int i = 0; i < n; i++) {
			String input = in.next();
			if(!add(input, trie)){
				System.out.println("BAD SET");
				System.out.println(input);
				return;
			}
		}
		System.out.println("GOOD SET");
		in.close();
	}
	public static boolean add(String input, Trie trie) {
		Trie triRef = trie;
		boolean repeatFlag = true;
		for (int i = 0; i < input.length(); i++) {
			Character inputChar = input.charAt(i);
			if (repeatFlag) {
				if (triRef.getTrieNode().containsKey(inputChar)) {
					triRef = triRef.getTrieNode().get(inputChar);
					triRef.setCount(triRef.getCount() + 1);
					if(triRef.isCompleted()){
						return false;
					}else{
						if(i+1==input.length()){
							return false;
						}
						continue;
					}
				} else {
					repeatFlag = false;
				}
			}

			triRef.getTrieNode().put(inputChar, new Trie());
			triRef = triRef.getTrieNode().get(inputChar);
		}
		triRef.setCompleted(true);
		return true;
	}

	public static void search(Trie trie, String searchStr) {}

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