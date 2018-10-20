package AVL;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sa = { 12, 25, 37, 50, 62, 75, 87 };
		
		AVL avl = new AVL(sa);
		avl.display();
		System.out.println("--------");
		avl.add(10);
		avl.add(5);
		avl.add(7);
		avl.add(6);
		avl.display();
		System.out.println("--------");
		avl.remove(6);
		avl.remove(5);
		avl.remove(7);
		avl.display();
		System.out.println("--------");
	}

}
