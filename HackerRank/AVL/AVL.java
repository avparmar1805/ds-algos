package AVL;

public class AVL {
	private class Node {
		int data;
		Node left;
		Node right;
		int height;
		int balance;
	}

	private Node root;

	public AVL(int[] sa) {
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
		node.height = getHeight(node);
		node.balance = getBalance(node);

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
		str += " <- " + node.data + "[" + node.height + "," + node.balance + "] -> ";
		str += node.right != null ? node.right.data + "" : ".";
		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	private int getHeight(Node node) {
		if(node == null) {
			return 0;
		}
		int lHt = node.left != null ? node.left.height : 0;
		int rHt = node.right != null ? node.right.height : 0;

		return Math.max(lHt, rHt) + 1;
	}

	private int getBalance(Node node) {
		if(node == null) {
			return 0;
		}
		int lHt = node.left != null ? node.left.height : 0;
		int rHt = node.right != null ? node.right.height : 0;

		return lHt - rHt;
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
			Node bnode = new Node();
			bnode.data = data;
			bnode.height = 1;
			bnode.balance = 0;
			return bnode;
		}

		if (node.data > data) {
			node.left = add(node.left, data);
		} else {
			node.right = add(node.right, data);
		}

		node.height = getHeight(node);
		node.balance = getBalance(node);

		if (node.balance > 1) {
			// left

			if (getBalance(node.left) > 0) {
				// ll
				node = rightRotate(node);
			} else {
				// lr
				node.left = leftRotate(node.left);
				node = rightRotate(node);
			}
		} else if (node.balance < -1) {
			// right
			if (getBalance(node.right) < 0) {
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

	private Node leftRotate(Node x) {
		Node y = x.right;
		Node t2 = y.left;
		y.left = x;
		x.right = t2;

		x.height = getHeight(x);
		x.balance = getBalance(x);

		y.height = getHeight(y);
		y.balance = getBalance(y);

		return y;
	}

	private Node rightRotate(Node x) {
		Node y = x.left;
		Node t3 = y.right;
		x.left = t3;
		y.right = x;

		x.height = getHeight(x);
		x.balance = getBalance(x);

		y.height = getHeight(y);
		y.balance = getBalance(y);

		return y;
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
			
		} else if (node.data < data) {
			node.right = remove(node.right, data);
		} else {
			if (node.left == null && node.right == null) {
				return null;
			} else if (node.left == null) {
				node =  node.right;
			} else if (node.right == null) {
				node = node.left;
			} else {
				int lmax = maxHelper(node.left);
				node.data = lmax;
				node.left = remove(node.left, lmax);
				
			}
		}
		node.height = getHeight(node);
		node.balance = getBalance(node);

		if (node.balance > 1) {
			// left

			if (getBalance(node.left) > 0) {
				// ll
				node = rightRotate(node);
			} else {
				// lr
				node.left = leftRotate(node.left);
				node = rightRotate(node);
			}
		} else if (node.balance < -1) {
			// right
			if (getBalance(node.right) < 0) {
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
}
