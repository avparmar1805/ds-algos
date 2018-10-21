package HashStory;

import java.util.ArrayList;
import java.util.HashMap;

public class Trie {
	private class Node {
		char data;
		HashMap<Character, Node> children = new HashMap<>();
		boolean eow;
	}

	Node root;
	int size;
	int words;

	public Trie() {
		root = new Node();
		root.data = '$';
		size = 1;
	}

	public void add(String str) {
		add(root, str);
	}

	private void add(Node node, String str) {

		if (str.isEmpty()) {
			node.eow = true;
			words++;
			return;
		}

		char fChar = str.charAt(0);
		String ros = str.substring(1);

		if (!node.children.containsKey(fChar)) {
			Node newNode = new Node();
			newNode.data = fChar;
			node.children.put(fChar, newNode);
			size++;
		}
		add(node.children.get(fChar), ros);

	}

	public void remove(String str) {
		remove(root, str);
	}

	private void remove(Node node, String str) {
		if (str.isEmpty()) {
			words--;
			node.eow = false;
			return;
		}

		char fChar = str.charAt(0);
		String ros = str.substring(1);

		if (node.children.containsKey(fChar)) {
			Node child = node.children.get(fChar);
			remove(child, ros);
			if (!child.eow && child.children.size() == 0) {
				size--;
				node.children.remove(fChar);
			}
		}
	}

	public boolean search(String str) {
		return search(root, str);
	}

	private boolean search(Node node, String str) {
		boolean found = false;

		if (str.isEmpty()) {
			return node.eow;
		}

		char fChar = str.charAt(0);
		String ros = str.substring(1);

		if (node.children.containsKey(fChar)) {
			found = search(node.children.get(fChar), ros);
		}
		return found;
	}

	public void displayAllWords() {
		displayAllWords(root, "");
	}

	private void displayAllWords(Node node, String pre) {

		if (node.eow) {
			System.out.println(pre);
		}

		for (char ch : new ArrayList<>(node.children.keySet())) {
			Node child = node.children.get(ch);
			displayAllWords(child, pre + child.data);
		}
	}

	public void displayAsTree() {
		displayAsTree(root);
	}

	private void displayAsTree(Node node) {
		
		String str = "";
		str += node.data + " =>";
		for (char ch : new ArrayList<>(node.children.keySet())) {
			Node child = node.children.get(ch);
			str += ch + ",";
		}
		System.out.println(str);
		for (char ch : new ArrayList<>(node.children.keySet())) {
			Node child = node.children.get(ch);
			displayAsTree(child);
		}
		
	}
}
