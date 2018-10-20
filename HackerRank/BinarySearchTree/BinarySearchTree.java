package BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class BinarySearchTree {
	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;
	private int size;

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int size() {
		return this.size;
	}

	public BinarySearchTree() {
		this.root = this.construct(new Scanner(System.in), root, true);
	}

	private Node construct(Scanner scn, Node parent, boolean ilc) {

		if (parent == null) {
			System.out.println("Enter the data for root ");
		} else {
			if (ilc) {
				System.out.println("Enter the data for left child of " + parent.data);
			} else {
				System.out.println("Enter the data for right child of " + parent.data);
			}
		}

		int data = scn.nextInt();

		Node child = new Node();
		child.data = data;
		this.size++;

		System.out.println("Do you have left child for " + child.data);
		boolean hlc = scn.nextBoolean();
		if (hlc) {
			child.left = this.construct(scn, child, true);
		}

		System.out.println("Do you have right child for " + child.data);
		boolean hrc = scn.nextBoolean();
		if (hrc) {
			child.right = this.construct(scn, child, false);
		}

		return child;
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";
		str += node.left != null ? node.left.data : ".";
		str += " =>" + node.data + "<= ";
		str += node.right != null ? node.right.data : ".";

		System.out.println(str);
		display(node.left);
		display(node.right);
	}

	public int size2() {
		return this.size2(this.root);
	}

	private int size2(Node node) {

		if (node == null) {
			return 0;
		}

		int lSize = size2(node.left);
		int rSize = size2(node.right);

		return lSize + rSize + 1;
	}

	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int max = node.data;

		int leftMax = max(node.left);
		int rightMax = max(node.right);

		int childMax = Math.max(leftMax, rightMax);

		max = Math.max(max, childMax);

		return max;
	}

	public int height() {
		return this.height(this.root);
	}

	public int height(Node node) {
		if (node == null) {
			return -1;
		}

		int leftHeight = height(node.left);
		int rightHeight = height(node.right);

		int height = Math.max(leftHeight, rightHeight) + 1;

		return height;
	}

	public boolean find(int data) {
		return this.find(this.root, data);
	}

	public boolean find(Node node, int data) {
		if (node == null) {
			return false;
		}

		if (node.data == data) {
			return true;
		}

		boolean foundInLeft = find(node.left, data);
		if (foundInLeft) {
			return true;
		}
		boolean foundInRight = find(node.right, data);

		if (foundInRight) {
			return true;
		}

		return false;
	}

	public void levelO() {
		LinkedList<Node> queue = new LinkedList<Node>();

		queue.addLast(this.root);

		while (!queue.isEmpty()) {
			Node node = queue.removeFirst();
			System.out.print(node.data + " - ");
			if (node.left != null)
				queue.addLast(node.left);
			if (node.right != null)
				queue.addLast(node.right);
		}

		System.out.println(".");
	}

	private static class IPair {
		public Node node;
		public boolean print = false;
		public boolean leftCall = false;
		public boolean rightCall = false;

		public IPair(Node node) {
			this.node = node;
		}
	}

	public void preoIterative() {
		LinkedList<IPair> stack = new LinkedList<IPair>();

		stack.addFirst(new IPair(this.root));

		while (stack.size() > 0) {

			IPair tp = stack.getFirst();

			if (tp.node == null) {
				stack.removeFirst();
				continue;
			}

			if (tp.print == false) {
				tp.print = true;
				System.out.print(tp.node.data + " ");
			} else if (tp.leftCall == false) {
				tp.leftCall = true;
				stack.addFirst(new IPair(tp.node.left));
			} else if (tp.rightCall == false) {
				tp.rightCall = true;
				stack.addFirst(new IPair(tp.node.right));
			} else {
				stack.removeFirst();
			}

		}
	}

	public void removeLeaf() {
		this.removeLeaf(this.root, this.root.left);
		this.removeLeaf(this.root, this.root.right);
	}

	private void removeLeaf(Node parent, Node child) {

		if (child == null) {
			return;
		}

		if (child.left == null && child.right == null) {
			if (parent.left == child) {
				parent.left = null;
			} else {
				parent.right = null;
			}

			return;
		}

		removeLeaf(child, child.left);
		removeLeaf(child, child.right);
	}

	public ArrayList<Integer> rootToNodePath(int data) {
		return this.rootToNodePath(this.root, data);
	}

	private ArrayList<Integer> rootToNodePath(Node node, int data) {
		if (node == null) {
			return new ArrayList<Integer>();
		}
		if (node.data == data) {
			ArrayList<Integer> path = new ArrayList<Integer>();
			path.add(node.data);
			return path;
		}

		ArrayList<Integer> pathFromLeftCall = rootToNodePath(node.left, data);
		if (pathFromLeftCall.size() > 0) {
			pathFromLeftCall.add(node.data);
			return pathFromLeftCall;
		}

		ArrayList<Integer> pathFromRightCall = rootToNodePath(node.right, data);
		if (pathFromRightCall.size() > 0) {
			pathFromRightCall.add(node.data);
			return pathFromRightCall;
		}

		return new ArrayList<Integer>();
	}

	public void printRootToNodePaths(int tar) {
		printRootToNodePaths(this.root, 0, "", tar);
	}

	private void printRootToNodePaths(Node node, int ssf, String psf, int tar) {

		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			if (ssf + node.data < tar) {
				psf += " " + node.data;
				System.out.println(psf);
			}
			return;
		}

		printRootToNodePaths(node.left, ssf + node.data, psf + " " + node.data, tar);
		printRootToNodePaths(node.right, ssf + node.data, psf + " " + node.data, tar);
	}

	public BinarySearchTree(int[] pre, int[] ino) {
		this.root = this.construct(pre, 0, pre.length - 1, ino, 0, ino.length - 1);
	}

	private Node construct(int[] pre, int psi, int pli, int[] ino, int isi, int ili) {

		if (psi > pli || isi > ili) {
			return null;
		}

		Node node = new Node();
		node.data = pre[psi];

		int idx = -1;
		for (idx = isi; idx <= ili; idx++) {
			if (pre[psi] == ino[idx]) {
				break;
			}
		}

		int nle = idx - isi;
		node.left = this.construct(pre, psi + 1, psi + nle, ino, isi, idx - 1);
		node.right = this.construct(pre, psi + nle + 1, pli, ino, idx + 1, ili);

		return node;
	}

	public BinarySearchTree(int[] post, int[] ino, boolean isPost) {
		this.root = this.construct(post, 0, post.length - 1, ino, 0, ino.length - 1, true);
	}

	private Node construct(int[] post, int psi, int pli, int[] ino, int isi, int ili, boolean isPost) {

		if (psi > pli || isi > ili) {
			return null;
		}

		Node node = new Node();
		node.data = post[pli];

		int idx = -1;
		for (idx = isi; idx <= ili; idx++) {
			if (post[pli] == ino[idx]) {
				break;
			}
		}

		int nre = ili - idx;
		node.left = this.construct(post, psi, pli - nre - 1, ino, isi, idx - 1, true);
		node.right = this.construct(post, pli - nre, pli - 1, ino, idx + 1, ili, true);

		return node;
	}

	public int diameter() {
		return this.diameter(this.root);
	}

	private int diameter(Node node) {
		if (node == null) {
			return 0;
		}
		int ld = diameter(node.left);
		int rd = diameter(node.right);

		int lh = height(node.left);
		int rh = height(node.right);

		int factor = lh + rh + 2;

		return Math.max(factor, Math.max(ld, rd));
	}

	public class BSTPair{
		boolean isBST;
		int min;
		int max;
	}
	
	public boolean isBST() {
		BSTPair bstPair =  this.isBST(this.root);
		return bstPair.isBST;
	}
	
	private BSTPair isBST(Node node) {
	
		if(node == null) {
			BSTPair bstPair = new BSTPair();
			bstPair.isBST = true;
			bstPair.min = Integer.MAX_VALUE;
			bstPair.max = Integer.MIN_VALUE;
			
			return bstPair;
		}
		
		BSTPair leftBSTPair = isBST(node.left);
		BSTPair rightBSTPair = isBST(node.right);
		
		BSTPair currBSTPair = new BSTPair();
		
		currBSTPair.isBST = leftBSTPair.isBST && rightBSTPair.isBST 
					&& node.data >= leftBSTPair.max
					&& node.data <= rightBSTPair.min;
		currBSTPair.max = Math.max(node.data, Math.max(leftBSTPair.max, rightBSTPair.max));
		currBSTPair.min = Math.min(node.data, Math.min(leftBSTPair.min, rightBSTPair.min));
		
		return currBSTPair;
	}
}
