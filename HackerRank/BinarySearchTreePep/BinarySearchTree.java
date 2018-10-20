package BinarySearchTreePep;

public class BinarySearchTree {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BinarySearchTree(int[] sa) {
		root = construct(sa, 0, sa.length - 1);
	}

	private Node construct(int[] sa, int lo, int hi) {

		if (lo > hi) {
			return null;
		}
		int mid = (lo + hi) / 2;
		Node node = new Node();
		node.data = sa[mid];
		node.left = construct(sa, lo, mid - 1);
		node.right = construct(sa, mid + 1, hi);

		return node;
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";
		str += node.left != null ? node.left.data + "" : ".";
		str += " <- " + node.data + " -> ";
		str += node.right != null ? node.right.data + "" : ".";
		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public int min() {
		return minHelper(this.root);
	}

	private int minHelper(Node node) {
		if (node.left == null && node.right == null) {
			return node.data;
		}
		return minHelper(node.left);
	}

	public int max() {
		return maxHelper(this.root);
	}

	private int maxHelper(Node node) {
		if (node.right == null && node.left == null) {
			return node.data;
		}
		return maxHelper(node.right);
	}

	public boolean find(int data) {
		return findHelper(this.root, data);
	}

	private boolean findHelper(Node node, int data) {
		if (node == null) {
			return false;
		}

		if (node.data == data) {
			return true;
		}
		if (node.data > data) {
			boolean filc = findHelper(node.left, data);
			if (filc) {
				return true;
			}
		} else {
			boolean firc = findHelper(node.right, data);
			if (firc) {
				return true;
			}
		}
		return false;
	}

	public void add(int data) {
		root = add(root, data);
	}

	private Node add(Node node, int data) {

		if (node == null) {
			node = new Node();
			node.data = data;
			return node;
		}

		if (node.data > data) {
			node.left = add(node.left, data);
		} else {
			node.right = add(node.right, data);
		}
		return node;
	}

	public void remove(int data) {
		root = remove(this.root, data);
	}

	private Node remove(Node node, int data) {

		if (node == null) {
			return null;
		}
		if (node.data > data) {
			node.left = remove(node.left, data);
			return node;
		} else if (node.data < data) {
			node.right = remove(node.right, data);
			return node;
		} else {
			if (node.left == null && node.right == null) {
				return null;
			} else if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			} else {
				int lmax = maxHelper(node.left);
				node.data = lmax;
				node.left = remove(node.left, lmax);
				return node;
			}
		}
	}

	public void printInRange(int lo, int hi) {
		printInRange(this.root, lo, hi);
	}

	private void printInRange(Node node, int lo, int hi) {

		if (node == null) {
			return;
		}
		if (node.data < lo) {
			printInRange(node.right, lo, hi);
		} else if (node.data > hi) {
			printInRange(node.left, lo, hi);
		} else {
			printInRange(node.left, lo, hi);
			System.out.println(" " + node.data + " ");
			printInRange(node.right, lo, hi);
		}
	}

	private int sum = 0;

	public void replaceWithSumOfLarger() {
		replaceWithSumOfLarger(this.root);
	}

	private void replaceWithSumOfLarger(Node node) {
		if (node == null) {
			return;
		}
		replaceWithSumOfLarger(node.right);

		int temp = node.data;
		node.data = sum;
		sum += temp;

		replaceWithSumOfLarger(node.left);

	}

	public int lca(int lo, int hi) {
		return lca(this.root, lo, hi);
	}

	private int lca(Node node, int lo, int hi) {

		if (node.data < lo) {
			return lca(node.right, lo, hi);
		} else if (node.data > hi) {
			return lca(node.left, lo, hi);
		} else {
			return node.data;
		}
	}

	public void printSum(int data) {
		printSum(this.root, data);
	}

	private void printSum(Node node, int data) {
		if(node == null) {
			return;
		}
		int con = data - node.data;
		boolean found = node.data < data/2 && find(con);
		if (found) {
			System.out.println(node.data + " " + con );
		}
		printSum(node.left, data);
		printSum(node.right, data);
	}
}
