package june27;

import java.util.ArrayList;
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
			if(node.eow == false){
				words++;
			}
			node.eow = true;
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
		removeWord(root, word);
	}
	
	private void removeWord(Node node, String word){
		if(word.length() == 0){
			node.eow = false;
			words--;
			return;
		}
		
		char ch = word.charAt(0);
		String row = word.substring(1);
		
		Node child = node.childen.get(ch);
		if(child == null){
			return;
		}
		removeWord(child, row);
		
		if(child.eow == false && child.childen.size() == 0){
			node.childen.remove(ch);
			nodes--;
		}
	}
	
	public void displayAllWords(){
		displayWords(root, "");
	}
	
	private void displayWords(Node node, String wsf){
		if(node.eow){
			System.out.println(wsf);
		}
		
		ArrayList<Character> keys = new ArrayList<>(node.childen.keySet());
		for(Character key: keys){
			Node child = node.childen.get(key);
			displayWords(child, wsf + key);
		}
	}
	
	public void displayTrie(){
		displayTrie(root);
	}

	private void displayTrie(Node node){
		System.out.println(node.data + " -> " + node.childen.keySet());
		ArrayList<Character> keys = new ArrayList<>(node.childen.keySet());
		for(Character key: keys){
			Node child = node.childen.get(key);
			displayTrie(child);
		}
	}
}
