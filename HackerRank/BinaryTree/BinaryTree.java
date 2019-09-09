package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

import java.util.TreeMap;
import java.util.Stack;

// Questions List
// 1. Construct - Steps
// a. Create a node
// a1. If stack is empty make the node as root, if not empty peek top from stack
// a2. if top left is empty assign to left else right
// increase size
// push to stack
// when -1 comes in array then pop top from stack
// 2. Display - Inorder traversal
// 3. max . height ( -1 - edges, 0 - node) , size, find
// 4. Vertical Order traversal, top view - Inorder traversal - while going left -1 from top, if go right then +1, save in 
// TreeMap<Integer, ArrayList<Integer>>
// 5. Node to root path : traverse node, left, right whenever found, create a new ArrayList and return, if AL.size > 0
// it means something is coming from its children so add itself as well
// 6. printKDown
// 7. printKFar
// 8. printSiblingLess
// 9. removeLeaves
// 10. Post, Pre, Level Order Traversal

// Binary Search Tree
// 1. Construct - Given a sorted array, find mid element and all left elements would be on left side of node, right elements would
// be on right. Divide the array recursively till 1 element is left
// 2. Max, min, find - keep in mind,as we go on more left, element is less than its node, and right side elements are greater
// 3. printInRange
// 4. Add, remove

public class BinaryTree {
	private class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	public Node root;
	public int size;
	private TreeMap<Integer, ArrayList<Integer>> hMap = new TreeMap();
	private TreeMap<Integer, Node> hMapForTV = new TreeMap();

	public BinaryTree(int[] arr) {
		// { 50, 25, 12, -1, 37, -1, -1, 75, 62, -1, 87, -1, -1, -1 }
		Stack<Node> st = new Stack<>();

		for (int val : arr) {
			if (val == -1) {
				st.pop();
			} else {
				Node node = new Node(0);
				node.data = val;
				if (st.isEmpty()) {
					this.root = node;
				} else {
					Node top = st.peek();

					if (top.left == null) {
						top.left = node;
					} else {
						top.right = node;
					}

				}
				size++;
				st.push(node);
			}
		}
	}

	public void display(Node node) {

		String str = "";

		str += node.left != null ? node.left.data : ".";
		str += " <- " + node.data + " -> ";
		str += node.right != null ? node.right.data : ".";

		System.out.println(str);

		if (node.left != null) {
			display(node.left);
		}
		if (node.right != null) {
			display(node.right);
		}
	}

	public void displayBTChars(Node node) {

		String str = "";

		str += node.left != null ? (char) node.left.data : ".";
		str += " <- " + (char) node.data + " -> ";
		str += node.right != null ? (char) node.right.data : ".";

		System.out.println(str);

		if (node.left != null) {
			displayBTChars(node.left);
		}
		if (node.right != null) {
			displayBTChars(node.right);
		}
	}

	public int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}
		int max = node.data;

		int leftMax = max(node.left);
		int rightMax = max(node.right);

		int currMax = Math.max(max, Math.max(leftMax, rightMax));

		return currMax;
	}

	public int height(Node node) {

		if (node == null) {
			return -1;
		}

		int leftHeight = height(node.left);
		int rightHeight = height(node.right);

		int childrenHeightMax = Math.max(leftHeight, rightHeight);

		return childrenHeightMax + 1;
	}

	public int size(Node node) {

		if (node == null) {
			return 0;
		}

		int leftSize = size(node.left);
		int rightSize = size(node.right);

		return leftSize + rightSize + 1;
	}

	public boolean find(Node node, int val) {
		if (node == null) {
			return false;
		}

		if (node.data == val) {
			return true;
		}

		boolean findInLeft = find(node.left, val);

		if (findInLeft) {
			return findInLeft;
		}

		boolean findInRight = find(node.right, val);

		if (findInRight) {
			return findInRight;
		}

		return false;
	}

	public void verticalOrderTraversal() {
		fillHashMapForVOT(this.root, 0);
		for (Entry<Integer, ArrayList<Integer>> entry : hMap.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

	private void fillHashMapForVOT(Node node, int val) {

		if (node == null) {
			return;
		}

		ArrayList<Integer> alAtNode = hMap.get(val);
		if (alAtNode == null) {
			alAtNode = new ArrayList<Integer>();
			alAtNode.add(node.data);
		} else {
			alAtNode.add(node.data);
		}

		hMap.put(val, alAtNode);
		fillHashMapForVOT(node.left, val - 1);
		fillHashMapForVOT(node.right, val + 1);
	}

	public void diagonalOrderTraversal() {
		fillHashMapForDiagonalOrderTraversal(this.root, 0);
		for (Entry<Integer, ArrayList<Integer>> entry : hMap.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

	private void fillHashMapForDiagonalOrderTraversal(Node node, int val) {

		if (node == null) {
			return;
		}

		ArrayList<Integer> alAtNode = hMap.get(val);
		if (alAtNode == null) {
			alAtNode = new ArrayList<Integer>();
			alAtNode.add(node.data);
		} else {
			alAtNode.add(node.data);
		}

		hMap.put(val, alAtNode);
		fillHashMapForDiagonalOrderTraversal(node.left, val + 1);
		fillHashMapForDiagonalOrderTraversal(node.right, val);
	}

	public void topView() {
		fillHashMapForTopView(this.root, 0);
		for (Entry<Integer, Node> entry : hMapForTV.entrySet()) {
			System.out.println(entry.getValue().data);
		}
	}

	public void fillHashMapForTopView(Node node, int val) {
		if (node == null) {
			return;
		}

		fillHashMapForTopView(node.left, val - 1);
		fillHashMapForTopView(node.right, val + 1);

		hMapForTV.put(val, node);
	}

	public ArrayList<Integer> nodeToRootPath(Node node, int data) {

		if (node == null) {
			ArrayList<Integer> al = new ArrayList<Integer>();
			return al;
		}

		ArrayList<Integer> resultList = new ArrayList<Integer>();

		if (node.data == data) {
			resultList.add(node.data);
		}

		ArrayList<Integer> leftList = nodeToRootPath(node.left, data);

		if (leftList.size() != 0) {

			resultList.addAll(leftList);
			resultList.add(node.data);
		}

		ArrayList<Integer> rightList = nodeToRootPath(node.right, data);

		if (rightList.size() != 0) {
			resultList.addAll(rightList);
			resultList.add(node.data);
		}

		return resultList;
	}

	public ArrayList<Node> nodeToRootPathNode(Node node, int data) {

		if (node == null) {
			ArrayList<Node> al = new ArrayList<Node>();
			return al;
		}

		ArrayList<Node> resultList = new ArrayList<Node>();

		if (node.data == data) {
			resultList.add(node);
		}

		ArrayList<Node> leftList = nodeToRootPathNode(node.left, data);

		if (leftList.size() != 0) {

			resultList.addAll(leftList);
			resultList.add(node);
		}

		ArrayList<Node> rightList = nodeToRootPathNode(node.right, data);

		if (rightList.size() != 0) {
			resultList.addAll(rightList);
			resultList.add(node);
		}

		return resultList;
	}

	public void printKDown(int data, int k) {
		Node foundNode = findNode(this.root, data);
		printKDown(foundNode, k);
	}

	private void printKDown(Node node, int k) {

		if (node == null) {
			return;
		}

		if (k == 0) {
			System.out.println((char) node.data);
		}
		printKDown(node.left, k - 1);
		printKDown(node.right, k - 1);
	}

	private Node findNode(Node node, int data) {

		Node foundNode = null;

		if (node == null) {
			return foundNode;
		}

		if (node.data == data) {
			foundNode = node;
			return foundNode;
		}

		foundNode = findNode(node.left, data);
		if (foundNode != null) {
			return foundNode;
		}
		foundNode = findNode(node.right, data);
		if (foundNode != null) {
			return foundNode;
		}
		return foundNode;
	}

	public void printKFar(int data, int k) {
		ArrayList<Node> path = nodeToRootPathNode(this.root, data);

		printKDown(path.get(0), k);

		for (int i = 1; i < k; i++) {
			Node currNode = path.get(i);
			Node prevNode = path.get(i - 1);

			boolean isLeft = currNode.left == prevNode ? true : false;

			if (isLeft) {
				printKDown(currNode.right, k - i - 1);
			} else {
				printKDown(currNode.left, k - i - 1);
			}
		}

		System.out.println((char) path.get(k).data);
	}

	int btMax = Integer.MIN_VALUE;
	int btSMax = Integer.MIN_VALUE;

	public int secondMax() {
		this.secondMax(this.root);
		return btSMax;
	}

	private void secondMax(Node node) {

		if (node == null) {
			return;
		}

		if (node.data > btMax) {
			btSMax = btMax;
			btMax = node.data;
		} else if (node.data > btSMax) {
			btSMax = node.data;
		}
		secondMax(node.left);
		secondMax(node.right);
	}

	public void boundaryTraversal(Node node) {

		// 1. Left boundary
		printLeft(this.root);
		// 3. Leaf Nodes
		printLeafNodes(this.root);
		// 2. Right Boundary
		printRight(this.root.right);

	}

	private void printLeft(Node node) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			System.out.println((char) node.data);
			printLeft(node.left);
		} else if (node.right != null) {
			System.out.println((char) node.data);
			printLeft(node.right);
		}

	}

	private void printRight(Node node) {
		if (node == null) {
			return;
		}
		if (node.right != null) {
			System.out.println((char) node.data);
			printRight(node.right);
		} else if (node.left != null) {
			System.out.println((char) node.data);
			printRight(node.left);
		}

	}

	private void printLeafNodes(Node node) {

		if (node == null) {
			return;
		}
		printLeafNodes(node.left);
		if (node.left == null && node.right == null) {
			// Leaf node found
			System.out.println((char) node.data);
		}
		printLeafNodes(node.right);

	}

	public void ConvertToDLL() {
		this.ConvertToDLL(this.root);
	}

	private void ConvertToDLL(Node node) {
		LinkedList<Node> queue = new LinkedList<>();
		Node head = null;
		Node prev = null;

		queue.add(node);

		while (!queue.isEmpty()) {
			Node p = queue.removeFirst();
			Node curr = new Node(p.data);
			if (prev == null) {
				head = curr;
			} else {
				curr.left = prev;
				prev.right = curr;
			}
			prev = curr;

			if (p.left != null) {
				queue.add(p.left);
			}
			if (p.right != null) {
				queue.add(p.right);
			}
		}
	}
	
	Node head = null;
	Node curr = null;
	
	public void ConvertLeavesToDLL() {
		this.ConvertLeavesToDLL(this.root);
		Node currPointer = head;
		while(currPointer != null) {
			System.out.println(currPointer.data + " ");
			currPointer = currPointer.right;
		}
	}
	
	private Node ConvertLeavesToDLL(Node node) {
		
		if(node == null) {
			return null;
		}
		if(node.left == null && node.right == null) {
			if(head == null) {
				head = node;
				curr = node;
			} else {
				curr.right = node;
				node.left = curr;
				curr = node;
			}
			
			return null;
		}
		node.left = ConvertLeavesToDLL(node.left);
		node.right = ConvertLeavesToDLL(node.right);
		
		return node;
	}
}
