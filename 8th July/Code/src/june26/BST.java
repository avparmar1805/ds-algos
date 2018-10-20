package june26;

public class BST {
	private class Node {
		int data;
		Node left;
		Node right;
	}

	Node root;
	int size;

	public BST(int[] sa) {
		root = construct(sa, 0, sa.length - 1);
	}

	private Node construct(int[] sa, int lo, int hi) {
		if (lo > hi) {
			return null;
		}

		int mid = (lo + hi) / 2;

		Node child = new Node();
		size++;

		child.data = sa[mid];
		child.left = construct(sa, lo, mid - 1);
		child.right = construct(sa, mid + 1, hi);

		return child;
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}

		String str = node.left != null ? node.left.data + " " : ". ";
		str += " <- " + node.data + " -> ";
		str += node.right != null ? node.right.data + " " : " .";
		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		if (node.right != null) {
			return max(node.right);
		} else {
			return node.data;
		}
	}

	public int min() {
		return min(root);
	}

	private int min(Node node) {
		if (node.left != null) {
			return min(node.left);
		} else {
			return node.data;
		}
	}

	public boolean find(int data) {
		return find(root, data);
	}

	private boolean find(Node node, int data) {
		if (node == null) {
			return false;
		}

		if (data > node.data) {
			return find(node.right, data);
		} else if (data < node.data) {
			return find(node.left, data);
		} else {
			return true;
		}
	}

	public void printinrange(int lo, int hi) {
		printinrange(root, lo, hi);
	}

	private void printinrange(Node node, int lo, int hi) {
		if (node == null) {
			return;
		}

		if (node.data > lo) {
			printinrange(node.left, lo, hi);
		}

		if (node.data >= lo && node.data <= hi) {
			System.out.println(node.data);
		}

		if (node.data < hi) {
			printinrange(node.right, lo, hi);
		}
	}

	private class HeapMover {
		int sum;
	}

	public void replaceWithSumOfLargerNodes() {
		// HeapMover mover = new HeapMover();
		// replaceWithSumOfLargerNodes(root, mover);
		rwls(root, 0);
	}

	// 87 75 62 50 37 25 12
	// 0 87 ..
	private void replaceWithSumOfLargerNodes(Node node, HeapMover mover) {
		if (node == null) {
			return;
		}

		replaceWithSumOfLargerNodes(node.right, mover);

		int temp = node.data;
		node.data = mover.sum;
		mover.sum += temp;

		replaceWithSumOfLargerNodes(node.left, mover);
	}

	public void addNode(int data) {
		root = addNode(root, data);
	}

	private Node addNode(Node node, int data) {
		if(node == null){
			this.size++;
			Node nn = new Node();
			nn.data = data;
			return nn;
		}
		
		if(data < node.data){
			node.left = addNode(node.left, data);
		} else if(data > node.data){
			node.right = addNode(node.right, data);
		}
		
		return node;
	}

	private int rwls(Node node, int sum) {
		if (node == null) {
			return sum;
		}

		sum = rwls(node.right, sum);

		int temp = node.data;
		node.data = sum;
		sum += temp;

		sum = rwls(node.left, sum);

		return sum;
	}

	public void removeNode(int data){
		root = removeNode(root, data);
	}
	
	private Node removeNode(Node node, int data){
		if(data < node.data){
			node.left = removeNode(node.left, data);
			return node;
		} else if(data > node.data){
			node.right = removeNode(node.right, data);
			return node;
		} else {
			if(node.left == null && node.right == null){
				return null;
			} else if(node.left == null){
				return node.right;
			} else if(node.right == null){
				return node.left;
			} else {
				int rmin = min(node.right);
				node.data = rmin;
				node.right = removeNode(node.right, rmin);
				return node;
			}
		}
	}
}











