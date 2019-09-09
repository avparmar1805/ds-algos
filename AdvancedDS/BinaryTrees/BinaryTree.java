package BinaryTrees;

import java.util.Stack;

public class BinaryTree {
	private class Node {
		int data;
		Node left;
		Node right;
	}

	public Node root;
	public int size;

	public BinaryTree(int[] arr) {
		// { 50, 25, 12, -1, 37, -1, -1, 75, 62, -1, 87, -1, -1, -1 }
		Stack<Node> st = new Stack<>();

		for (int val : arr) {
			if (val == -1) {
				st.pop();
			} else {
				Node node = new Node();
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

	public void displayBT(Node node) {

		String str = "";

		str += node.left != null ? node.left.data : ".";
		str += " <- " + node.data + " -> ";
		str += node.right != null ? node.right.data : ".";

		System.out.println(str);

		if (node.left != null) {
			displayBT(node.left);
		}
		if (node.right != null) {
			displayBT(node.right);
		}
	}

	Stack<Integer> st = new Stack();

	public int kSmallest(int k) {
		return this.KSmallest(this.root, k);
	}

	private int KSmallest(Node node, int k) {
		if (node == null) {
			return -1;
		}

		if (st.size() == k) {
			return st.peek();
		}

		int lRetVal = KSmallest(node.left, k);

		if (lRetVal != -1) {
			return lRetVal;
		}

		st.push(node.data);

		int rRetVal = KSmallest(node.right, k);
		if (rRetVal != -1) {
			return rRetVal;
		}
		if (st.size() == k) {
			return st.peek();
		}
		return -1;
	}

	public int lca(int data1, int data2) {
		Node node = lca(this.root, data1, data2);
		return node.data;
	}

	private Node lca(Node node, int data1, int data2) {
		if (node == null) {
			return null;
		}

		if (node.data == data1 || node.data == data2) {
			return node;
		}

		Node leftCall = lca(node.left, data1, data2);
		Node rightCall = lca(node.right, data1, data2);

		if (leftCall != null && rightCall != null) {
			return node;
		}

		return leftCall != null ? leftCall : rightCall;
	}
}
