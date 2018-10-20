package BinarySearchTree;

import java.util.ArrayList;

public class Client {

	public static void main(String[] args) throws Exception {

		// 50 true 25 true 12 false true 20 false false true 37 true 30 false false false true 75 true 62 false false true 87 false false
		//BinarySearchTree bst = new BinarySearchTree();

		// System.out.println(bst.size());
		// bst.display();
		// System.out.println(bst.max());
		// System.out.println(bst.find(62));

		// bst.levelO();
		// bst.preoIterative();

		// bst.removeLeaf();
		// bst.display();

		// ArrayList<Integer> path = bst.rootToNodePath(30);
		//
		// for (Integer data : path) {
		// System.out.print(data + " => ");
		// }

		// bst.printRootToNodePaths(150);

		//int[] preO = { 50, 25, 12, 20, 37, 30, 75, 62, 87 };
		int[] ino = { 12, 20, 25, 30, 37, 50, 62, 75, 87 };
		int[] post = { 20, 12, 30, 37, 25, 62, 87, 75, 50 };

		//BinarySearchTree bstFromArr = new BinarySearchTree(preO, ino);
		BinarySearchTree bstFromPostArr = new BinarySearchTree(post, ino, true);
		//bstFromArr.display();
		bstFromPostArr.display();
		System.out.println(bstFromPostArr.isBST());
	}
}
