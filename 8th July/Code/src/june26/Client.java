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
		
		System.out.println("----------------");
		bst.addNode(30);
		bst.addNode(70);
		bst.display();
		
		System.out.println("----------------");
		bst.removeNode(30);
		bst.removeNode(62);
		bst.removeNode(50);
		bst.display();
	}

}
