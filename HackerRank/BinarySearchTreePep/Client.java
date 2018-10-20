package BinarySearchTreePep;

import BinarySearchTreePep.BinarySearchTree;

public class Client {

	public static void main(String[] args) {
		// int[] arr = {'a', 'b', 'd', 'f', 'h', -1, -1, 'g', 'i', 'm', 'o', 'v',
		// -1, -1, 'p', 't', -1, -1, -1, 'n', 'q', 'u', -1, 'w', -1, -1, -1, -1,
		// 'j', 'k', 'r', 'x', -1, -1, -1, 'l', 's', 'y',
		// -1, -1, -1, -1, -1, -1, -1, 'c', 'e', 'z', -1, -1, -1, -1};

		// int[] arr = { 50, 25, 12, -1, 37, 30, -1, 51, -1, -1, -1, 75, 62, 60, -1, -1,
		// 87, -1, -1, -1 };
		// BinaryTree bt = new BinaryTree(arr);
		// bt.preo();
		// bt.posti();
		// bt.posto();
		// bt.ino();
		// bt.levelo();

		// bt.printSiblingLess();
		// bt.removeLeaves();
		// bt.display();
		// bt.rootToLeafPathInRange(150, 250);
		// bt.display();
		// bt.printKFar('i', 3);
		// System.out.println(bt.size());
		// System.out.println(bt.max());
		// System.out.println(bt.height());
		// System.out.println(bt.find(87));
		// int[] preo = { 50, 25, 12, 37, 30, 24, 33, 40, 75, 62, 87 };
		// int[] ino = { 12, 25, 24, 30, 33, 37, 40, 50, 62, 75, 87 };
		// // int[] post = { 90, 10, 12, 40, 37, 25, 70, 62, 87, 75, 50 };
		// BinaryTree bt1 = new BinaryTree(preo, ino);
		// // System.out.println(bt1.isBalanced());
		// bt1.display();
		// System.out.println(bt1.isBST());
		int[] sa = { 12, 25, 37, 50, 63, 75, 87 };
		BinarySearchTree bst = new BinarySearchTree(sa);
		//bst.display();
//		 System.out.println(bst.min());
//		 System.out.println(bst.max());
//		 System.out.println(bst.find(12));
		 bst.add(30);
//		 bst.add(40);
		 bst.display();
		 //System.out.println(bst.lca(37, 62));
//		 bst.replaceWithSumOfLarger();
//		 System.out.println("--------");
////		 bst.remove(25);
		// bst.display();	
		 bst.printSum(100);
	}

}
