package BinaryTrees;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr =  { 50, 25, 12, -1, 37, -1, -1, 75, 62, -1, 87, -1, -1, -1 };
		BinaryTree bt = new BinaryTree(arr);
		bt.displayBT(bt.root);
//		System.out.println(bt.kSmallest(3));
		System.out.println(bt.lca(12,37));
	}

}
