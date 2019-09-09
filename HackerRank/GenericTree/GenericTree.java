package GenericTree;

import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GenericTree {

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<Node>();
		boolean extremePosition;
	}

	private Node root;
	private int size;

	public GenericTree() {
		root = construct(new Scanner(System.in), null, 0);
	}

	// expectation -> creates returns ith child of parent
	private Node construct(Scanner scn, Node parent, int i) {
		if (parent == null) {
			System.out.println("Enter the data for root");
		} else {
			System.out.println("Enter the data for " + i + "th child of " + parent.data);
		}
		int cData = scn.nextInt();
		Node child = new Node();
		size++;
		child.data = cData;

		System.out.println("Enter the number of children for " + child.data);
		int numgc = scn.nextInt();

		for (int j = 0; j < numgc; j++) {
			Node gc = construct(scn, child, j);
			child.children.add(gc);
		}

		return child;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		String str = node.data + "=>";
		for (Node child : node.children) {
			str += child.data + ", ";
		}
		str += ".";
		System.out.println(str);
		for (Node child : node.children) {
			display(child);
		}
	}

	public int size2() {
		return this.size2(root);
	}

	private int size2(Node node) {
		int size = 0;

		for (Node child : node.children) {
			int cSize = size2(child);
			size += cSize;
		}

		return size + 1;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		int max = node.data;

		for (Node child : node.children) {
			int cmax = max(child);
			if (cmax > max) {
				max = cmax;
			}
		}
		return max;
	}

	public boolean find(int data) {
		return this.find(root, data);
	}

	private boolean find(Node node, int data) {
		if (node.data == data) {
			return true;
		}

		for (Node child : node.children) {
			boolean fic = find(child, data);
			if (fic) {
				return true;
			}
		}

		return false;
	}

	public int height() {
		return this.height(root);
	}

	private int height(Node node) {
		int cmaxht = -1;

		for (Node child : node.children) {
			int cht = height(child);
			cmaxht = Math.max(cmaxht, cht);
		}

		return cmaxht + 1;
	}

	public void preo() {
		this.preo(root);
	}

	private void preo(Node node) {

		System.out.print(node.data + " ");
		for (Node child : node.children) {
			preo(child);
		}
	}

	public void posto() {
		this.posto(root);
	}

	private void posto(Node node) {

		for (Node child : node.children) {
			posto(child);
		}
		System.out.print(node.data + " ");
	}

	public void levelO() {
		LinkedList<Node> queue = new LinkedList<Node>();

		queue.addLast(root);
		while (!queue.isEmpty()) {
			Node rem = queue.removeFirst();
			System.out.print(rem.data + " ");

			for (Node child : rem.children) {
				queue.addLast(child);
			}
		}

		System.out.println(".");
	}

	private class Pair {
		Node node;
		int level;
	}

	public void levelOlw() {
		LinkedList<Pair> queue = new LinkedList<Pair>();

		Pair rootPair = new Pair();
		rootPair.level = 0;
		rootPair.node = root;

		queue.addLast(rootPair);
		Pair prev = null;

		while (!queue.isEmpty()) {
			Pair curr = queue.removeFirst();

			if (prev != null && prev.level != curr.level) {
				System.out.println();
			}
			System.out.print(curr.node.data + " ");

			for (Node child : curr.node.children) {
				Pair cpair = new Pair();
				cpair.node = child;
				cpair.level = curr.level + 1;
				queue.addLast(cpair);
			}

			prev = curr;
		}

	}

	public void levelOzz() {
		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> stack = new LinkedList<>();

		queue.add(root);
		boolean l2r = true;

		while (!queue.isEmpty()) {
			Node node = queue.removeFirst();

			System.out.print(node.data + " ");

			if (l2r) {
				for (int i = 0; i < node.children.size(); i++) {
					Node child = node.children.get(i);
					stack.addFirst(child);
				}
			} else {
				for (int i = node.children.size() - 1; i >= 0; i--) {
					Node child = node.children.get(i);
					stack.addFirst(child);
				}
			}

			if (queue.size() == 0) {
				queue = stack;
				stack = new LinkedList<>();
				System.out.println();
				l2r = !l2r;
			}
		}
	}

	public void mirror() {
		mirror(root);
	}

	private void mirror(Node node) {
		for (Node child : node.children) {
			mirror(child);
		}

		Collections.reverse(node.children);
	}

	public void removeLeaves() {
		removeLeaves(root);
	}

	private void removeLeaves(Node node) {
		for (int i = node.children.size() - 1; i >= 0; i--) {
			Node child = node.children.get(i);
			if (child.children.size() == 0) {
				node.children.remove(child);
			} else {
				removeLeaves(child);
			}
		}
	}

	public void linearize() {
		linearize(root);
	}

	private void linearize(Node node) {
		for (Node child : node.children) {
			linearize(child);
		}

		while (node.children.size() > 1) {
			Node sl = node.children.get(node.children.size() - 2);
			Node l = node.children.remove(node.children.size() - 1);

			Node tail = getTail(sl);
			tail.children.add(l);
		}
	}

	public Node getTail(Node node) {
		Node tail = node;

		while (tail.children.size() == 1) {
			tail = tail.children.get(0);
		}

		return tail;
	}

	public void linearizeEff() {
		linearizeEff(root);
	}

	private Node linearizeEff(Node node) {

		if (node.children.size() == 0) {
			return node;
		}

		Node oTail = linearizeEff(node.children.get(node.children.size() - 1));
		while (node.children.size() > 1) {
			Node sl = node.children.get(node.children.size() - 2);
			Node l = node.children.get(node.children.size() - 1);

			Node slTail = linearizeEff(sl);
			node.children.remove(l);
			slTail.children.add(l);
		}
		return oTail;
	}

	public boolean isIsomorphic(GenericTree other) {
		return this.isIsomorphic(this.root, other.root);
	}

	@SuppressWarnings("unused")
	private boolean isIsomorphic(Node currNode, Node otherNode) {

		if (currNode.children.size() == otherNode.children.size()) {
			for (int i = 0; i < currNode.children.size(); i++) {
				Node currChild = currNode.children.get(i);
				Node otherChild = otherNode.children.get(i);

				boolean isCIsomorphic = isIsomorphic(currChild, otherChild);
				if (isCIsomorphic == false)
					return false;
				return true;
			}
		} else {
			return false;
		}

		return false;
	}

	public boolean isMirrorOf(GenericTree other) {
		return this.isMirrorOf(this.root, other.root);
	}

	private boolean isMirrorOf(Node tNode, Node otherNode) {
		if (tNode.children.size() != otherNode.children.size()) {
			return false;
		}

		int left = 0;
		int right = otherNode.children.size() - 1;
		while (left < tNode.children.size()) {
			Node tCNode = tNode.children.get(left);
			Node oCNode = otherNode.children.get(right);

			boolean isMirror = isMirrorOf(tCNode, oCNode);
			if (isMirror == false) {
				return false;
			}

			left++;
			right--;
		}
		return true;
	}

	public boolean isSymmetric() {
		return isMirrorOf(this.root, this.root);
	}

	public class HeapMover {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int size = 0;
		int height = 0;
		boolean found = false;

		Node prev = null;
		Node curr = null;
		Node pred = null;
		Node succ = null;
		Node jL = null;
	}

	public void multiSolver(int data) {
		HeapMover heapMover = new HeapMover();
		multiSolver(this.root, heapMover, data, 0);
		System.out.println("Size = " + heapMover.size);
		System.out.println("Min = " + heapMover.min);
		System.out.println("Max = " + heapMover.max);
		System.out.println("Found = " + heapMover.found);
		System.out.println("Height = " + heapMover.height);
	}

	private void multiSolver(Node node, HeapMover heapMover, int data, int depth) {

		if (node.data > heapMover.max) {
			heapMover.max = node.data;
		}

		if (node.data < heapMover.min) {
			heapMover.min = node.data;
		}

		if (node.data == data) {
			heapMover.found = true;
		}

		if (depth > heapMover.height) {
			heapMover.height = depth;
		}

		heapMover.size++;

		for (Node child : node.children) {
			multiSolver(child, heapMover, data, depth + 1);
		}
	}

	public void predSucc(int data) {
		HeapMover heapMover = new HeapMover();
		predSucc(this.root, heapMover, data);

		System.out.println("Pred = " + (heapMover.pred == null ? "null" : heapMover.pred.data));
		System.out.println("Succ = " + (heapMover.succ == null ? "null" : heapMover.succ.data));
	}

	private void predSucc(Node node, HeapMover heapMover, int data) {
		heapMover.curr = node;

		if (data == heapMover.curr.data) {
			heapMover.pred = heapMover.prev;
		} else if (heapMover.prev != null && heapMover.prev.data == data) {
			heapMover.succ = heapMover.curr;
		}	

		heapMover.prev = node;
		for (Node child : node.children) {
			predSucc(child, heapMover, data);
		}
	}

	public void justLarger(int data) {
		HeapMover mover = new HeapMover();
		justLarger(this.root, mover, data);
		System.out.println("Just Larger = " + (mover.jL == null ? "null" : mover.jL.data));
	}

	private void justLarger(Node node, HeapMover mover, int data) {

		if (node.data > data) {
			if (mover.jL == null || node.data < mover.jL.data) {
				mover.jL = node;
			}
		}

		for (Node child : node.children) {
			justLarger(child, mover, data);
		}
	}

	public int kThSmallest(int k) {
		HeapMover mover = new HeapMover();

		int data = Integer.MIN_VALUE;
		for (int i = 0; i < k; i++) {
			justLarger(root, mover, data);
			data = mover.jL.data;
			mover.jL = null;
		}

		return data;
	}

	public void LeftView() {
		this.LeftView(this.root, 0);
	}

	private static int maxLevel = -1;

	private void LeftView(Node node, int level) {

		if (maxLevel < level) {
			System.out.println(node.data + " .");
			maxLevel = level;
		}

		for (Node child : node.children) {
			LeftView(child, level + 1);
		}
	}

	public void RightView() {
		this.RightView(this.root, 0);
	}

	private static int rightMaxLevel = -1;

	private void RightView(Node node, int level) {

		if (rightMaxLevel < level) {
			System.out.println(node.data + " .");
			rightMaxLevel = level;
		}

		for (int i = node.children.size() - 1; i >= 0; i--) {
			RightView(node.children.get(i), level + 1);
		}
	}

	public void PrintIntersectionNodes() {
		LinkedList<Node> q = new LinkedList();
		boolean levelChange = true;
		
		root.extremePosition = true;
		q.addLast(root);
		q.addLast(null); // to manage levels added null
		
		while (q.size() > 0) {
			Node node = q.removeFirst();
			if(node == null) {
				// means next node will be at higher level
				levelChange = true;
			} else {
				if (!node.extremePosition) {
					System.out.println(node.data + ".");
				}
				for (int i = 0; i < node.children.size(); i++) {
					Node child = node.children.get(i);
					if ((i == 0 || i == node.children.size() - 1) && levelChange) {
						child.extremePosition = true;
					}
					q.addLast(child);
				}
				levelChange = false;
				q.addLast(null);
			}
		}
	}
}
