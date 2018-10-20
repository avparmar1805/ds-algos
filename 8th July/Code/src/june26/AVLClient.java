package june26;

public class AVLClient {

	public static void main(String[] args) {
		AVL avl = new AVL(new int [] {12, 25, 37, 50, 62, 75, 87});
		avl.addNode(10);
		avl.addNode(5);
		avl.display();
		
		System.out.println("--------------------------------");
		avl.removeNode(5);
		avl.removeNode(37);
		avl.display();
	}

}
