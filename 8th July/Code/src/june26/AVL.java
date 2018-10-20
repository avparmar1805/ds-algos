package june26;

public class AVL {
	private class Node {
		int data;
		Node left;
		Node right;
		int ht;
		int bf;
	}

	Node root;
	int size;

	public AVL(int[] sa) {
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
		child.ht = height(child);
		child.bf = getBalanceFactor(child);

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
		str += " <- " + node.data + "[" + node.ht + ", " + node.bf + "] -> ";
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
		if (node == null) {
			this.size++;
			Node nn = new Node();
			nn.data = data;
			return nn;
		}

		if (data < node.data) {
			node.left = addNode(node.left, data);
		} else if (data > node.data) {
			node.right = addNode(node.right, data);
		}
		
		node.ht = height(node);
		node.bf = getBalanceFactor(node);
		
		// ll, lr, rr, rl
		if(node.bf > 1){
			// ll or lr
			if(node.left.bf > 0){
				// ll
				node = rightRotate(node);
			} else {
				// lr
				node.left = leftRotate(node.left);
				node = rightRotate(node);
			}
		} else if(node.bf < -1){
			// rr or rl
			if(node.right.bf < 0){
				// rr
				node = leftRotate(node);
			} else {
				// rl
				node.right = rightRotate(node.right);
				node = leftRotate(node);
			}
		}

		return node;
	}

	private Node leftRotate(Node z) {
		Node y = z.right;
		Node t2 = y.left;
		
		y.left = z;
		z.right = t2;
		
		z.ht = height(z);
		z.bf = getBalanceFactor(z);
		y.ht = height(y);
		y.bf = getBalanceFactor(y);
		
		return y;
	}

	private Node rightRotate(Node z) {
		Node y = z.left;
		Node t3 = y.right;
		
		y.right = z;
		z.left = t3;
		
		z.ht = height(z);
		z.bf = getBalanceFactor(z);
		y.ht = height(y);
		y.bf = getBalanceFactor(y);
		
		return y;
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

	public void removeNode(int data) {
		root = removeNode(root, data);
	}

	private Node removeNode(Node node, int data) {
		if (data < node.data) {
			node.left = removeNode(node.left, data);
		} else if (data > node.data) {
			node.right = removeNode(node.right, data);
		} else {
			if (node.left == null && node.right == null) {
				return null;
			} else if (node.left == null) {
				node = node.right;
			} else if (node.right == null) {
				node = node.left;
			} else {
				int rmin = min(node.right);
				node.data = rmin;
				node.right = removeNode(node.right, rmin);
			}
		}
		
		node.ht = height(node);
		node.bf = getBalanceFactor(node);
//		
//		// ll, lr, rr, rl
		if(node.bf > 1){
			// ll or lr
			if(node.left.bf > 0){
				// ll
				node = rightRotate(node);
			} else {
				// lr
				node.left = leftRotate(node.left);
				node = rightRotate(node);
			}
		} else if(node.bf < -1){
			// rr or rl
			if(node.right.bf < 0){
				// rr
				node = leftRotate(node);
			} else {
				// rl
				node.right = rightRotate(node.right);
				node = leftRotate(node);
			}
		}
		
		return node;
	}

	private int getBalanceFactor(Node node) {
		if(node == null){
			return 0;
		}
		return height(node.left) - height(node.right);
	}

	private int height(Node node) {
		if(node == null){
			return -1;
		}
		
		int lh = -1;
		int rh = -1;

		if (node.left != null) {
			lh = node.left.ht;
		}

		if (node.right != null) {
			rh = node.right.ht;
		}
		
		return Math.max(lh, rh) + 1;
	}
}
