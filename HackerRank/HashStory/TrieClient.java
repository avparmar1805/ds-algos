package HashStory;

public class TrieClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie = new Trie();
		trie.add("are");
		trie.add("and");
		trie.add("ant");
		trie.add("ask");
		trie.add("sea");
		trie.add("art");
		trie.add("an");
		trie.add("as");
		trie.add("see");
		trie.add("seen");
		trie.displayAsTree();
		trie.displayAllWords();
//		System.out.println(trie.search("as") + " " +  trie.search("ask")); 
//		trie.remove("as");
//		System.out.println(trie.search("as") + " " +  trie.search("ask")); 
//		trie.remove("ask");
//		//trie.displayAllWords();
//		System.out.println(trie.search("an") + " " +  trie.search("and")); 
//		trie.remove("an");
//		System.out.println(trie.search("an") + " " +  trie.search("and")); 
//		trie.remove("and");
//		System.out.println(trie.search("an") + " " +  trie.search("and")); 
	}

}
