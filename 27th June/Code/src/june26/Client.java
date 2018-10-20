package june26;

public class Client {
	public static void main(String[] args) {
		int[] sa = {12, 25, 37, 50, 62, 75, 87};
		BST bst = new BST(sa);
		bst.display();
		
//		bst.printinrange(36, 83);
//		bst.replaceWithSumOfLargerNodes();
//		System.out.println("-------------------------------");
//		bst.display();
		
		bst.addNode(40);
		bst.addNode(60);
		
		bst.display();
	}

}
