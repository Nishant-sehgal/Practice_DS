package com.design.cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRU {
	static Queue<String> queue = new LinkedList<String>();
	static Map<String, String> map = new HashMap<>();
	private static final int SIZE = 5;

	public static void main(String[] args) {
		LRU.setVal("1", "1");
		LRU.setVal("2", "2");
		LRU.setVal("3", "3");
		LRU.setVal("4", "4");
		LRU.get("1");
		LRU.get("1");
		LRU.get("1");
		LRU.get("1");
		LRU.setVal("5", "5");
		LRU.setVal("6", "6");
		System.out.println(queue);
		System.out.println(LRU.map);
	}

	public static String get(String val) {
		String value = map.get(val);
		if (null != value) {
			queue.remove(val);
			queue.add(val);
		}
		return value;
	}

	public static String remove(String key) {
		queue.remove(key);
		return map.remove(key);
	}

	public static void setVal(String key, String value) {
		if (map.size() < SIZE) {
			map.put(key, value);
			queue.add(key);
		} else {
			String queueVal = queue.remove();
			map.remove(queueVal);
			map.put(key, value);
			queue.add(key);
		}
	}
}

class CacheStrategies {

	public interface CacheStrategy<K, T> {
		T get(K key);

		void put(K key, T data);
	}

	class CacheStrategyLRU<K, T> implements CacheStrategy<K, T> {

		class Node {
			K key;
			T data;
			Node next;
			Node prev;

			public Node(K key, T data) {
				this.key = key;
				this.data = data;
			}
		}

		Node head, tail;
		Map<K, Node> map;
		int maxsize;

		public CacheStrategyLRU(int mxsize) {
			this.maxsize = mxsize;
			map = new HashMap<K, Node>();
			head = new Node(null, null);
			tail = new Node(null, null);
			head.next = tail;
			tail.prev = head;
		}

		private void attach(Node head, Node node) {
			node.prev = head;
			node.next = head.next;
			head.next.prev = node;
			head.next = node;
		}

		private void remove(Node node) {
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}

		@Override
		public T get(K key) {
			Node node = map.get(key);
			if (node == null) {
				return null;
			}

			if (map.size() == 1) {
				return node.data;
			}
			remove(node);
			attach(head, node);
			return node.data;
		}

		@Override
		public void put(K key, T data) {
			if (maxsize <= 0) {
				return;
			}
			Node node = map.get(key);
			if (node != null) {
				remove(node);
				attach(head, node);
				node.data = data;
			} else {
				if (map.size() >= maxsize) {
					remove(tail.prev);// tail is node pointer ,its not containg
										// any node so delete tail.prev
					map.remove(tail.prev.key);
				}
				Node nd = new Node(key, data);
				map.put(key, nd);
				attach(head, nd);
			}

		}

	}

}