package org.handsoncoder.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	Node root;
	boolean isWord;

	class Node {
		boolean isWord;
		Map<Character, Node> children;

		public Node() {
			isWord = false;
			children = new HashMap<>();
		}
	}

	/** Initialize your data structure here. */
	public Trie() {
		this.root = new Node();
		this.isWord = false;
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		Node cur = this.root;
		for (char c : word.toCharArray()) {
			if (!cur.children.containsKey(c)) {
				cur.children.put(c, new Node());
			}
			cur = cur.children.get(c);
		}
		cur.isWord = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		Node cur = this.root;
		for (char c : word.toCharArray()) {
			if (!cur.children.containsKey(c)) {
				return false;
			}
			cur = cur.children.get(c);
		}
		return cur.isWord;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		Node cur = this.root;
		for (char c : prefix.toCharArray()) {
			if (!cur.children.containsKey(c)) {
				return false;
			}
			cur = cur.children.get(c);
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
