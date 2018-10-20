package june27;

import java.util.HashMap;

public class Trie {
	private class Node {
		Character data;
		HashMap<Character, Node> childen = new HashMap<>();
		boolean eow = false;
	}
	
	private Node root;
	private int words;
	private int nodes;
	
	public Trie(){
		this.root = new Node();
		this.words = 0;
		this.nodes = 1;
	}
	
	public void addWord(String word){
		addWord(root, word);
	}
	
	private void addWord(Node node, String word){
		if(word.length() == 0){
			node.eow = true;
			words++;
			return;
		}
		
		char ch = word.charAt(0);
		String row = word.substring(1);
		
		Node child = node.childen.get(ch);
		
		if(child == null){
			child = new Node(); // create
			child.data = ch;
			node.childen.put(ch, child); // attach
			nodes++;
		}
		
		addWord(child, row);
	}
	
	public boolean searchWord(String word){
		return searchWord(root, word);
	}
	
	private boolean searchWord(Node node, String word){
		if(word.length() == 0){
			return node.eow;
		}
		
		char ch = word.charAt(0);
		String row = word.substring(1);
		
		if(node.childen.containsKey(ch)){
			Node child = node.childen.get(ch);
			return searchWord(child, row);
		} else {
			return false;
		}
	}
	
	public void removeWord(String word){
		
	}
	
	public void displayAllWords(){
		
	}
	
	public void displayTrie(){
		
	}
}
